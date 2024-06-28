package hw03;
public class TestedClass {


    @Before
    public void methodOne(){
       System.out.println ( "before" );
    }

    @Test
    public  void methodSix(){
        throw new RuntimeException ();
    }
    @Test
    public  void methodTwo(){
        System.out.println ( "test" );
    }
    @After
    public void methodThree(){
        System.out.println ( "after" );
    }


    @After
    @Test
    public  void methodFour(){
         throw new RuntimeException ();
    }

    @Before
    @Test
    public  void methodFive(){
        throw new RuntimeException ();
    }


}
