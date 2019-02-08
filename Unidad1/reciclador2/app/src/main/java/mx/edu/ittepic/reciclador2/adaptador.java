package mx.edu.ittepic.reciclador2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class adaptador extends RecyclerView.Adapter<adaptador.RecyclerViewHolder> {

    private String[] nombres;
    private String[] numeroControl;
    private Context contexto; //carga de recursos para obtener un servicio de sistema


    public adaptador(String[] nombres, String[] numeroControl, Context contexto) {
        this.nombres = nombres; //palabra reservada y sirve para hacer referencia a la instasncis sctual
        this.numeroControl = numeroControl;
        this.contexto = contexto;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //crea un nuevo titular cunado no hay titulares, se encarga de mostrar los elementos
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.formulario, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        //es el que se encarga de obtener nuevos daros y tendra que llenar con datos no utilizados
        holder.campo_nombre.setText(nombres[position]);
        holder.campo_numeroControl.setText(numeroControl[position]);
        holder.actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contexto, "ACTUALIZASTE A: " + nombres[position] + '\n' +
                        "NO.Control:" + numeroControl[position], Toast.LENGTH_LONG).show();
            }
        });
        holder.borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contexto, "ELIMINASTE A: " + nombres[position] + '\n' +
                        "NO.Control:" + numeroControl[position], Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        //metodo encargado de devolver el numero de elementos al recyclerview principal
        return nombres.length;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView campo_nombre;
        TextView campo_numeroControl;
        ImageView actualizar, borrar;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            //ViewHolder para almacenar datos que facilitan el contenido de las vistas vinculantes.


            campo_nombre = itemView.findViewById(R.id.nombre);
            campo_numeroControl = itemView.findViewById(R.id.carrera);

            actualizar = itemView.findViewById(R.id.imagen);
            borrar = itemView.findViewById(R.id.imagen2);


        }
    }

}

