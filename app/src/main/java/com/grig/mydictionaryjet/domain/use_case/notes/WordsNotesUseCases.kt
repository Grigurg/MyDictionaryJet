package com.grig.mydictionaryjet.domain.use_case.notes

data class WordsNotesUseCases(
    val getWordsNotes: GetWordsNotes,
    val getWordsNote: GetWordsNote,
    val insertWordsNote: InsertWordsNote,
    val deleteWordsNote: DeleteWordsNote
)