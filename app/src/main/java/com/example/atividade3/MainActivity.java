package com.example.atividade3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.atividade3.adapters.PlaceholderAlbumAdapter;
import com.example.atividade3.adapters.PlaceholderCommentAdapter;
import com.example.atividade3.adapters.PlaceholderPostAdapter;
import com.example.atividade3.model.PlaceholderAlbum;
import com.example.atividade3.model.PlaceholderComment;
import com.example.atividade3.model.PlaceholderPost;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONArray>,
        Response.ErrorListener{

    private List<PlaceholderPost> listaPosts = new ArrayList<>();
    private List<PlaceholderComment> listaComments = new ArrayList<>();
    private List<PlaceholderAlbum> listaAlbums = new ArrayList<>();
    private int button = 0;

    private final int POST = 1;
    private final int COMMENT = 2;
    private final int ALBUM = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Botao 1
        Button btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getListPosts();
                button = POST;
            }
        });

        //Botao 2
        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getListComments();
                button = COMMENT;
            }
        });

        //Botao 3
        Button btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getListAlbums();
                button = ALBUM;
            }
        });
    }

    protected void getListComments() {
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/comments",null,
                this,this);
        queue.add(requisicao);
    }

    protected void getListPosts() {
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/posts",null,
                this,this);
        queue.add(requisicao);
    }

    protected void getListAlbums() {
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/albums",null,
                this,this);
        queue.add(requisicao);
    }

    @Override
    public void onResponse(JSONArray response) {
        listaPosts.clear();
        listaComments.clear();
        for (int i = 0; i < response.length(); i++) {
            try {
                switch (button) {
                    case POST:
                        listaPosts.add(new PlaceholderPost(response.getJSONObject(i)));
                        break;
                    case COMMENT:
                        listaComments.add(new PlaceholderComment(response.getJSONObject(i)));
                        break;
                    case ALBUM:
                        listaAlbums.add(new PlaceholderAlbum(response.getJSONObject(i)));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + button);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        RecyclerView.Adapter adapter;

        switch (button) {
            case POST:
                adapter = new PlaceholderPostAdapter(listaPosts);
                break;
            case COMMENT:
                adapter = new PlaceholderCommentAdapter(listaComments);
                break;
            case ALBUM:
                adapter = new PlaceholderAlbumAdapter(listaAlbums);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + button);
        }



        preparaRecylerView(adapter);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
    /*
        EditText ed = findViewById(R.id.editTextTextMultiLine);
        ed.setText(error.getMessage());
        */

    }

    public void preparaRecylerView(RecyclerView.Adapter adapter){
        RecyclerView rv = findViewById(R.id.rvPlaceholder);
        LinearLayoutManager llm =  new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
    }


}