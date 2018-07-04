package theblackpanther;

public class Note {
    private String noteContent;

    public Note(String noteContent) {
        setNoteContent(noteContent);
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public String displayNote(){
        return getNoteContent();
    }
}
