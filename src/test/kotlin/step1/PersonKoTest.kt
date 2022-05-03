package step1

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec ({

    "named arguments" {
        val people: List<Person> = listOf(
            Person("황민호", 39, "로빈"),
            Person("황민호", 39, nickname = "로빈"),
            Person(name = "황민호", nickname = "로빈", age = 39)
        )
        people.forAll {
            it.name shouldBe "황민호"
            it.age shouldBe 39
            it.nickname shouldBe "로빈"
        }
    }

    "nullable types" {
        val person = Person("황민호", 39, null)

        person.name shouldBe "황민호"
        person.age shouldBe 39
        person.nickname shouldBe null
    }

    "default arguments" {
        val person = Person("황민호")

        person.name shouldBe "황민호"
        person.age shouldBe null
        person.nickname shouldBe null
    }

    "data classes" {
        val person1 = Person("황민호", 39, "로빈")
        val person2 = Person("황민호", 39, "로빈")

        person1 shouldBe person2
    }
})