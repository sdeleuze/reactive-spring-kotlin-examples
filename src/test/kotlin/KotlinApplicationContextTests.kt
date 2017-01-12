import org.junit.Assert.assertNotNull
import org.junit.Test
import org.springframework.beans.factory.getBean
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.registerBean

class KotlinApplicationContextTests {

    @Test
    fun javaLikeRegisterBean() {
        val context = GenericApplicationContext()
        context.registerBean(A::class)
        context.registerBean{ B(it.getBean(A::class)) }
        context.refresh()

        assertNotNull(context.getBean(A::class))
        assertNotNull(context.getBean(B::class))
    }

    @Test
    fun idiomaticKotlinRegisterBean() {
        val context = GenericApplicationContext {
            registerBean<A>()
            registerBean{ B(it.getBean<A>()) }
        }
        context.refresh()

        assertNotNull(context.getBean<A>())
        assertNotNull(context.getBean<B>())
    }

    class A

    class B(val a:A)
}