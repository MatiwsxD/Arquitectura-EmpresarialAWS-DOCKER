import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;

public class MongoConection {
    public static MongoClient client;
    public static MongoDatabase db;
    public static MongoCollection col;

    public MongoConection(){
        client= MongoClients.create("mongodb+srv://prueba:1234@cluster0.lm1ec.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        db = client.getDatabase("RRDatabase");
        col = db.getCollection("Messages");

    }

    public static void addMensaje(Mensaje mensaje){
        FindIterable findIterable = col.find();
        ArrayList<Document> documents = new ArrayList<Document>();
        findIterable.into(documents);
        Document sampleDoc = new Document("_id", documents.size()+1).append("mensaje",mensaje.getInfo()).append("Fecha",mensaje.getDate());
        col.insertOne(sampleDoc);

    }
    public static ArrayList<Mensaje> getMensaje(){
        FindIterable findIterable = col.find();
        ArrayList<Document> documents = new ArrayList<Document>();
        findIterable.into(documents);
        ArrayList<Mensaje> messages = new ArrayList<Mensaje>();
        for(int i = documents.size(); i>=documents.size(); i--){
            String x = (String) documents.get(i).get("mensaje");
            Date y = (Date) documents.get(i).get("Fecha");
            messages.add(new Mensaje(x,y));
        }
        return messages;
    }

}
