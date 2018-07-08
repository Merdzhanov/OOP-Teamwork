package theblackpanther;

class Note {
    private String noteContent;

    Note(String noteContent) {
        setNoteContent(noteContent);
    }

    String getNoteContent() {
        return noteContent;
    }

    private void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
}
