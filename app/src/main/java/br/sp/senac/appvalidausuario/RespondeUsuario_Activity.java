package br.sp.senac.appvalidausuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RespondeUsuario_Activity extends AppCompatActivity {

    ListView listView;
    String[] nomePersonagens ={"Ciborgue","Venom","Flash","Mulher Maravilha",
            "Dead Pool","Batman"} ;
    int[] imagemdosPersonagens = {R.drawable.logo_ciborgue, R.drawable.logo_venom, R.drawable.flash,
    R.drawable.logo_mm, R.drawable.dpool, R.drawable.fundo_batman};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.responde_usuario_layout);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);


        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Listar_Personagens_Activity.class);
                intent.putExtra("name",nomePersonagens[position]);
                intent.putExtra("image",imagemdosPersonagens[position]);
                startActivity(intent);
            }
        });



    }
    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return imagemdosPersonagens.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView , ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.carrega_personagens, null);
            TextView name = (TextView) view1.findViewById(R.id.txtPersongens);
            ImageView imagem = (ImageView) view1.findViewById(R.id.imgPersonagens);
            name.setText(nomePersonagens[position]);
            imagem.setImageResource(imagemdosPersonagens[position]);
            return view1;
        }
    }
}
