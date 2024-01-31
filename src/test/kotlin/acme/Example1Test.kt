package acme

import acme.Example1Test.AlphabetParty.A
import acme.Example1Test.AlphabetParty.B
import dev.kensa.ActionUnderTest
import dev.kensa.GivensBuilder
import dev.kensa.junit.KensaExtension
import dev.kensa.kotlin.KotlinKensaTest
import dev.kensa.state.CapturedInteractionBuilder
import dev.kensa.state.Party
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(KensaExtension::class)
class Example1Test: KotlinKensaTest {
    enum class AlphabetParty : Party {
        A, B, C, D, E, F, G, H, I, J, K, L;
        override fun asString(): String = "The_party_currently_known_as_${name}"
    }

    @Test
    fun shouldRenderNarrowSequenceDiagram() {
        given(someThingIsDone())
        whenever(fewThingsHappen())
    }

    @Test
    fun shouldRenderWideSequenceDiagram() {
        given(someThingIsDone())
        whenever(manyThingsHappen())
    }

    private fun someThingIsDone(): GivensBuilder {
        return GivensBuilder { _ -> }
    }

    private fun fewThingsHappen(): ActionUnderTest {
        return ActionUnderTest { _, interactions ->
            interactions.capture(
                CapturedInteractionBuilder
                    .from(A)
                    .to(B)
                    .with("message", "A Message to B")
            )
        }
    }

    private fun manyThingsHappen(): ActionUnderTest {
        return ActionUnderTest { _, interactions ->
            AlphabetParty
                .entries
                .forEach {
                    interactions.capture(CapturedInteractionBuilder
                        .from(A)
                        .to(it)
                        .with("message", "A Message to ${it.name}")
                    )
                }
        }
    }
}