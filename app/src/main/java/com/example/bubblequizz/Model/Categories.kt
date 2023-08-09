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
        override val apiName = "General knowledge"
        override val iconLocation = "../" //TODO (dewhs) Tu peux rajouter les icones là
    },
    EntertainmentBooks {
        override val apiName = "Entertainment: Books"
        override val iconLocation = "../"
    },
    EntertainmentFilm {
        override val apiName = "Entertainment: Film"
        override val iconLocation = "../"
    },
    EntertainmentMusic {
        override val apiName = "Entertainment: Music"
        override val iconLocation = "../"
    },
    EntertainmentTelevision {
        override val apiName = "Entertainment: Television"
        override val iconLocation = "../"
    },
    EntertainmentMusicalsAndTheatres {
        override val apiName = "Entertainment: Musicals & Theatres"
        override val iconLocation = "../"
    },
    EntertainmentVideoGames {
        override val apiName = "Entertainment: Video Games"
        override val iconLocation = "../"
    },
    EntertainmentBoardGames {
        override val apiName = "Entertainment: Board Games"
        override val iconLocation = "../"
    },
    ScienceAndNature {
        override val apiName = "Science & Nature"
        override val iconLocation = "../"
    },
    ScienceComputer {
        override val apiName = "Science: Computers"
        override val iconLocation = "../"
    },
    Mythology {
        override val apiName = "Mythology"
        override val iconLocation = "../"
    },
    Sports {
        override val apiName = "Sports"
        override val iconLocation = "../"
    },
    Geography {
        override val apiName = "Geography"
        override val iconLocation = "../"
    },
    History {
        override val apiName = "History"
        override val iconLocation = "../"
    },
    Politics {
        override val apiName = "Politics"
        override val iconLocation = "../"
    },
    Art {
        override val apiName = "Art"
        override val iconLocation = "../"
    },
    Celebrities {
        override val apiName = "Celebrities"
        override val iconLocation = "../"
    },
    Animals {
        override val apiName = "Animals"
        override val iconLocation = "../"
    },
    Vehicles {
        override val apiName = "Vehicles"
        override val iconLocation = "../"
    },
    EntertainmentComics {
        override val apiName = "Entertainment: Comics"
        override val iconLocation = "../"
    },
    EntertainmentGadgets {
        override val apiName = "Science: Gadgets"
        override val iconLocation = "../"
    },
    EntertainmentJapaneseAnimeAndManga {
        override val apiName = "Entertainment: Japanese Anime & Manga"
        override val iconLocation = "../"
    },
    EntertainmentCartoonAndAnimations {
        override val apiName = "Entertainment: Cartoon & Animations"
        override val iconLocation = "../"
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