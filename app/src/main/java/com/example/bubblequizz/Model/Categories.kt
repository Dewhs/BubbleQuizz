package com.example.bubblequizz.Model


/**
 * An instance of a question
 */
data class Question(val parameters: QuestionParameters, val content: QuestionContent)

/**
 * The parameters of a Question, based on the Trivia API
 */
data class QuestionParameters(val category: Categories, val type: Type, val difficulty: Difficulty)

/**
 * The content of a Question, based on the Trivia API
 */
data class QuestionContent(
    val question: String,
    val correct_answer: String,
    val incorrect_answer: List<String>
)

/**
 * The different types of difficulty to a Question
 *
 * The enum constants are of the same name of the Trivia API, with an uppercase
 *
 */
enum class Difficulty {
    Easy,
    Medium,
    Hard,
}

/**
 * The different types of answers to a Question
 *
 * The enum constants are of the same name of the Trivia API, with an uppercase
 *
 */
enum class Type {
    Multiple,
    Boolean,
}

/**
 * The different types of categories to a Question
 * They each holds specific values attached which may finds its use in the UI mostly
 *
 * [fromApiId] and [fromApiName] are for your convenience
 */
enum class Categories {
    GeneralKnowledge {
        override val apiName: String = "General knowledge"
        override val iconLocation: String = "../" //TODO (dewhs) Tu peux rajouter les icones là
    },
    EntertainmentBooks {
        override val apiName: String = "Entertainment: Books"
        override val iconLocation: String = "../"
    },
    EntertainmentFilm {
        override val apiName: String = "Entertainment: Film"
        override val iconLocation: String = "../"
    },
    EntertainmentMusic {
        override val apiName: String = "Entertainment: Music"
        override val iconLocation: String = "../"
    },
    EntertainmentTelevision {
        override val apiName: String = "Entertainment: Television"
        override val iconLocation: String = "../"
    },
    EntertainmentMusicalsAndTheatres {
        override val apiName: String = "Entertainment: Musicals & Theatres"
        override val iconLocation: String = "../"
    },
    EntertainmentVideoGames {
        override val apiName: String = "Entertainment: Video Games"
        override val iconLocation: String = "../"
    },
    EntertainmentBoardGames {
        override val apiName: String = "Entertainment: Board Games"
        override val iconLocation: String = "../"
    },
    ScienceAndNature {
        override val apiName: String = "Science & Nature"
        override val iconLocation: String = "../"
    },
    ScienceComputer {
        override val apiName: String = "Science: Computers"
        override val iconLocation: String = "../"
    },
    Mythology {
        override val apiName: String = "Mythology"
        override val iconLocation: String = "../"
    },
    Sports {
        override val apiName: String = "Sports"
        override val iconLocation: String = "../"
    },
    Geography {
        override val apiName: String = "Geography"
        override val iconLocation: String = "../"
    },
    History {
        override val apiName: String = "History"
        override val iconLocation: String = "../"
    },
    Politics {
        override val apiName: String = "Politics"
        override val iconLocation: String = "../"
    },
    Art {
        override val apiName: String = "Art"
        override val iconLocation: String = "../"
    },
    Celebrities {
        override val apiName: String = "Celebrities"
        override val iconLocation: String = "../"
    },
    Animals {
        override val apiName: String = "Animals"
        override val iconLocation: String = "../"
    },
    Vehicles {
        override val apiName: String = "Vehicles"
        override val iconLocation: String = "../"
    },
    EntertainmentComics {
        override val apiName: String = "Entertainment: Comics"
        override val iconLocation: String = "../"
    },
    EntertainmentGadgets {
        override val apiName: String = "Science: Gadgets"
        override val iconLocation: String = "../"
    },
    EntertainmentJapaneseAnimeAndManga {
        override val apiName: String = "Entertainment: Japanese Anime & Manga"
        override val iconLocation: String = "../"
    },
    EntertainmentCartoonAndAnimations {
        override val apiName: String = "Entertainment: Cartoon & Animations"
        override val iconLocation: String = "../"
    };


    val apiId: Int
        get() {
            // Id starts at 9 on the Trivia API
            return ordinal + 9
        }
    abstract val apiName: String;
    abstract val iconLocation: String;


    companion object {
        fun fromApiId(id: Int): Categories {
            assert(id >= 9) { "An id was asked to be resolved to its categories while being less than 9, the Trivia API start at 9." }
            assert(id <= 32) { "An id was asked to be resolved to its categories while being more than 32, the Trivia API stop at 32." }
            return Categories.entries[id - 9]
        }

        // May not be useful
        fun fromApiName(apiName: String): Categories? {
            for (value in Categories.values()) {
                if (value.apiName == apiName) return value
            }
            return null
        }
    }

}