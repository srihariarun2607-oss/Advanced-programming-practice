interface Confidential { }

class Document {
    String title;
    Document(String title) {
        this.title = title;
    }
}

class Report extends Document implements Confidential {
    Report(String title) {
        super(title);
    }
}

class Notice extends Document {
    Notice(String title) {
        super(title);
    }
}

public class DocumentSystem {
    public static void main(String[] args) {
        Document d1 = new Report("Annual Financial Report");
        Document d2 = new Notice("Holiday Notice");

        if (d1 instanceof Confidential) {
            System.out.println(d1.title + " is confidential.");
        }
        if (d2 instanceof Confidential) {
            System.out.println(d2.title + " is confidential.");
        } else {
            System.out.println(d2.title + " is not confidential.");
        }
    }
}
