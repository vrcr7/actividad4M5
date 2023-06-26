package com.example.actividad4m5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.actividad4m5.databinding.FragmentResultBinding;


public class ResultFragment extends Fragment {

    FragmentResultBinding resultBinding;
    Button boton;
    TextView texto;

    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        resultBinding=FragmentResultBinding.inflate(inflater,container,false);
        texto=resultBinding.textResult;
        boton=resultBinding.botonVolver;
        Bundle arguments = getArguments();
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        if(arguments.getBoolean("resultado")){

            texto.setText("¡Genial "+arguments.getString("nombre")+", Ganaste!");
        }else{
            texto.setText("Bueno, te equivocaste "+arguments.getString("nombre")+", ¡INTENTALO OTRA VEZ!");
        }
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigateUp();
            }
        });
        return resultBinding.getRoot();
    }
}