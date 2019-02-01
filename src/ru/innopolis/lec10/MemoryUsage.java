package ru.innopolis.lec10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.SoftReference;

public class MemoryUsage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MemoryUsage.class);

    /**
     * @return a string representation of the object.
     */
    public static class User {

        public String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println(String.format("destroy user object %s", this));
        }

        public static void info() {
            int mb = 1024 * 1024;
            Runtime runtime = Runtime.getRuntime();
            System.out.println("#### Heap utilization statistic [MB] #######");
            System.out.println("Used Memory:" +
                    (runtime.freeMemory() - runtime.freeMemory()) / mb);
            System.out.println("Free Memory:" +
                    runtime.freeMemory() / mb);
            System.out.println("Total memory:" +
                    runtime.freeMemory() / mb);
        }
    }

    public static void main(String[] args) {
        //System.out.println("start");
        //        info();
        //        SoftReference<MemoryUsage> user = new SoftReference<>(new MemoryUsage("test"));
        int i = 0;
        while (true) {
            User user = new User("test " + i);
            user.info();
            System.out.println(user);
            System.out.println(user.toString());
            user = null;
            //System.gc();
            //info();
            i++;
        }
    }
}