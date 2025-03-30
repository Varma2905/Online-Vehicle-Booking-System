class ThrowsDemo {
    void throwsOne() throws IllegalArgumentException {
        System.out.println("Hello");
        throw new IllegalArgumentException("Demo Exception");
    }

    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo(); // Create an instance
        try {
            demo.throwsOne();
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
