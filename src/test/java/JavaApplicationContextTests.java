import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

public class JavaApplicationContextTests {

    @Test
    public void registerBean() {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(A.class);
        context.registerBean(B.class, () -> new B(context.getBean(A.class)));
        context.refresh();

        assertNotNull(context.getBean(A.class));
        assertNotNull(context.getBean(B.class));
    }

    static class A {
    }

    static class B {
        public B(A a) {
        }
    }
}