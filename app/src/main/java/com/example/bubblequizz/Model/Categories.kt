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
        override val iconLocation = R.drawable.head_thinking
    },
    EntertainmentBooks {
        override val apiName = "Entertainment: Books"
        override val iconLocation = R.drawable.book
    },
    EntertainmentFilm {
        override val apiName = "Entertainment: Film"
        override val iconLocation = R.drawable.film
    },
    EntertainmentMusic {
        override val apiName = "Entertainment: Music"
        override val iconLocation = R.drawable.music
    },
    EntertainmentTelevision {
        override val apiName = "Entertainment: Television"
        override val iconLocation = R.drawable.screen
    },
    EntertainmentMusicalsAndTheatres {
        override val apiName = "Entertainment: Musicals & Theatres"
        override val iconLocation = R.drawable.microphone
    },
    EntertainmentVideoGames {
        override val apiName = "Entertainment: Video Games"
        override val iconLocation = R.drawable.gamepad
    },
    EntertainmentBoardGames {
        override val apiName = "Entertainment: Board Games"
        override val iconLocation = R.drawable.dice
    },
    ScienceAndNature {
        override val apiName = "Science & Nature"
        override val iconLocation = R.drawable.leaf
    },
    ScienceComputer {
        override val apiName = "Science: Computers"
        override val iconLocation = R.drawable.laptop
    },
    Mythology {
        override val apiName = "Mythology"
        override val iconLocation = R.drawable.myth
    },
    Sports {
        override val apiName = "Sports"
        override val iconLocation = R.drawable.basketball
    },
    Geography {
        override val apiName = "Geography"
        override val iconLocation = R.drawable.earth
    },
    History {
        override val apiName = "History"
        override val iconLocation = R.drawable.time_fast
    },
    Politics {
        override val apiName = "Politics"
        override val iconLocation = R.drawable.flag
    },
    Art {
        override val apiName = "Art"
        override val iconLocation = R.drawable.palette
    },
    Celebrities {
        override val apiName = "Celebrities"
        override val iconLocation = R.drawable.star
    },
    Animals {
        override val apiName = "Animals"
        override val iconLocation = R.drawable.fox
    },
    Vehicles {
        override val apiName = "Vehicles"
        override val iconLocation = R.drawable.car
    },
    EntertainmentComics {
        override val apiName = "Entertainment: Comics"
        override val iconLocation = R.drawable.comments
    },
    EntertainmentGadgets {
        override val apiName = "Science: Gadgets"
        override val iconLocation = R.drawable.pendrive
    },
    EntertainmentJapaneseAnimeAndManga {
        override val apiName = "Entertainment: Japanese Anime & Manga"
        override val iconLocation = R.drawable.japanes_strength
    },
    EntertainmentCartoonAndAnimations {
        override val apiName = "Entertainment: Cartoon & Animations"
        override val iconLocation = R.drawable.star_7
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