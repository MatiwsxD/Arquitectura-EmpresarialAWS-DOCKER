import static spark.Spark.*;
import com.google.gson.Gson;
public class App {

    public static void main(String[] args){
        MongoConection conexion = new MongoConection();
        get("/connect", (req, res) -> {
            res.status(200);
            res.type("application/json");
            return new Gson().toJson(conexion.getMensaje());
        });
        post("/connect", (req, res) -> {
            System.out.println(req+" "+res);
            Mensaje mensaje = new Mensaje(req.body());
            System.out.println(req.body());
            conexion.addMensaje(mensaje);
            return null;
        });

    }
    public static int getPort(){
        if (System.getenv("PORT") !=null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }


}
