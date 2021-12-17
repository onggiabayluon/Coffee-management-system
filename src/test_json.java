// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.Writer;
// import java.lang.ProcessBuilder.Redirect.Type;
// import java.util.ArrayList;
// import java.util.List;

// import com.google.gson.Gson;
// import com.google.gson.GsonBuilder;
// import com.google.gson.reflect.TypeToken;
// import com.google.gson.stream.JsonReader;

// public class utils {
//     public static Gson gson = new Gson();
    
//     public void writeJson(List<Dish> dishes) {
//         try (Writer writer = new FileWriter("E:/010_work/Personal/School/Programming/Java/QuanLiCaPhe/src/data/dish.json")) {
            
//             Gson gson = new GsonBuilder().setPrettyPrinting().create();
//             gson.toJson(dishes, writer);
//             System.out.println("Write succesfully");
            
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     public void readJson(String filePath) {
//         Type REVIEW_TYPE = new TypeToken<ArrayList<Dish>>() {}.getType();
//         JsonReader reader = new JsonReader(new FileReader(filePath));
//         Dish data = gson.fromJson(reader, REVIEW_TYPE); // contains the whole reviews list
//         data.toScreen(); // prints to screen some values
//     }
// }
