import org.junit.Test
import reactor.test.StepVerifier

class KotlinReactorTests {

    @Test
    fun toMono() {
        val monoFoo = "foo".toMono()

        StepVerifier.create(monoFoo)
                .expectNext("foo")
                .verifyComplete()
    }
}