package com.grig.mydictionaryjet.domain.use_case

import com.grig.mydictionaryjet.domain.use_case.database.DeleteWordsNote
import com.grig.mydictionaryjet.domain.use_case.database.GetWordsNote
import com.grig.mydictionaryjet.domain.use_case.database.GetWordsNotes
import com.grig.mydictionaryjet.domain.use_case.database.InsertWordsNote

data class WordsNotesUseCases(
    val getWordsNotes: GetWordsNotes,
    val getWordsNote: GetWordsNote,
    val insertWordsNote: InsertWordsNote,
    val deleteWordsNote: DeleteWordsNote
)