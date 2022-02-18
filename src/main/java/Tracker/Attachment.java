package Tracker;

public abstract class Attachment {

    //todo здесь это не нужно, поля необходимо перенести в наследники, для коментария String, для дефекта int
    String attachment;

    //todo в этом конструкторе надобность также отпадает, у каждого наследника свой конструктор
    public Attachment(String attachment) {
        this.attachment = attachment;
    }

    public String asString() {
    return attachment;
    }

}
