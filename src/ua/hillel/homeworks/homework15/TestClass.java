package ua.hillel.homeworks.homework15;

public class TestClass {
    @BeforeSuite
    public void doMethodBefore() {
        System.out.println("Before");
    }

    @Test(priority = 3)
    public void doMethodTest1() {
        System.out.println("Text1");
    }

    @Test(priority = 2)
    public void doMethodTest2() {
        System.out.println("Text2");
    }

    @Test
    public void doMethodTest3() {
        System.out.println("Text3");
    }

    @Test(priority = 5)
    public void doMethodTest4() {
        System.out.println("Text4");
    }

    @AfterSuite
    public void doMethodAfter() {
        System.out.println("After");
    }
}
