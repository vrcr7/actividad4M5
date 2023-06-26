package com.example.actividad4m5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class IniFragment extends Fragment {

    EditText texto;

    public IniFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ini, container, false);

        Button botonNavegacion = rootView.findViewById(R.id.botonComenzar);
        texto=rootView.findViewById(R.id.textoNombre);
        botonNavegacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dato = texto.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("dato", dato);

                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);


                navController.navigate(R.id.action_iniFragment_to_icoFragment,bundle);
            }
        });

        return rootView;
    }
}