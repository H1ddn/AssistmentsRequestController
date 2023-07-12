package Enum;

public enum Method {
    A {
        @Override
        public void print(){
            System.out.println("A");
        }
    },
    B{
        @Override
        public void print(){
            System.out.println("B");
        }
    },
    C{
        @Override
        public void print(){
            System.out.println("C");
        }
    },
    AB{
        @Override
        public void print(){
            System.out.println("AB");
        }
    },
    AC{
        @Override
        public void print(){
            System.out.println("AC");
        }
    },
    BC{
        @Override
        public void print(){
            System.out.println("BC");
        }
    },
    ABC{
        @Override
        public void print(){
            System.out.println("ABC");
        }
    };
    public abstract void print();
}
