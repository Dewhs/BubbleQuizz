package com.example.bubblequizz.Model

import com.example.bubblequizz.R


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
        override val iconLocation = R.drawable.earth //TODO (dewhs) Tu peux rajouter les icones là
    },
    EntertainmentBooks {
        override val apiName = "Entertainment: Books"
        override val iconLocation = R.drawable.earth
    },
    EntertainmentFilm {
        override val apiName = "Entertainment: Film"
        override val iconLocation = R.drawable.earth
    },
    EntertainmentMusic {
        override val apiName = "Entertainment: Music"
        override val iconLocation = R.drawable.earth
    },
    EntertainmentTelevision {
        override val apiName = "Entertainment: Television"
        override val iconLocation = R.drawable.earth
    },
    EntertainmentMusicalsAndTheatres {
        override val apiName = "Entertainment: Musicals & Theatres"
        override val iconLocation = R.drawable.earth
    },
    EntertainmentVideoGames {
        override val apiName = "Entertainment: Video Games"
        override val iconLocation = R.drawable.earth
    },
    EntertainmentBoardGames {
        override val apiName = "Entertainment: Board Games"
        override val iconLocation = R.drawable.earth
    },
    ScienceAndNature {
        override val apiName = "Science & Nature"
        override val iconLocation = R.drawable.leaf
    },
    ScienceComputer {
        override val apiName = "Science: Computers"
        override val iconLocation = R.drawable.earth
    },
    Mythology {
        override val apiName = "Mythology"
        override val iconLocation = R.drawable.earth
    },
    Sports {
        override val apiName = "Sports"
        override val iconLocation = R.drawable.earth
    },
    Geography {
        override val apiName = "Geography"
        override val iconLocation = R.drawable.map
    },
    History {
        override val apiName = "History"
        override val iconLocation = R.drawable.time_fast
    },
    Politics {
        override val apiName = "Politics"
        override val iconLocation = R.drawable.earth
    },
    Art {
        override val apiName = "Art"
        override val iconLocation = R.drawable.earth
    },
    Celebrities {
        override val apiName = "Celebrities"
        override val iconLocation = R.drawable.earth
    },
    Animals {
        override val apiName = "Animals"
        override val iconLocation = R.drawable.earth
    },
    Vehicles {
        override val apiName = "Vehicles"
        override val iconLocation = R.drawable.earth
    },
    EntertainmentComics {
        override val apiName = "Entertainment: Comics"
        override val iconLocation = R.drawable.earth
    },
    EntertainmentGadgets {
        override val apiName = "Science: Gadgets"
        override val iconLocation = R.drawable.earth
    },
    EntertainmentJapaneseAnimeAndManga {
        override val apiName = "Entertainment: Japanese Anime & Manga"
        override val iconLocation = R.drawable.earth
    },
    EntertainmentCartoonAndAnimations {
        override val apiName = "Entertainment: Cartoon & Animations"
        override val iconLocation = R.drawable.earth
    };


    val apiId: Int
        get() {
            // Id starts at 9 on the Trivia API
            return ordinal + 9
        }
    abstract val apiName: String;
    abstract val iconLocation: Int;


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