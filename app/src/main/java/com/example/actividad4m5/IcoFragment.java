package com.example.actividad4m5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.actividad4m5.databinding.FragmentIcoBinding;

public class IcoFragment extends Fragment {

   private FragmentIcoBinding icoBinding;
   private Button boton;
   private RadioGroup grupo;
   private TextView texto;

    public IcoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        icoBinding= FragmentIcoBinding.inflate(inflater, container, false);
        texto=icoBinding.textNombre;
        boton=icoBinding.botonEnviar;
        Bundle arguments = getArguments();
        Bundle bundle=new Bundle();
        bundle.putString("nombre", arguments.getString("dato"));
        if (arguments != null) {
             texto.setText("Hola!, "+arguments.getString("dato"));
        }

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putBoolean("resultado",respuesta());
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);


                navController.navigate(R.id.action_icoFragment_to_resultFragment,bundle);
            }
        });



        return icoBinding.getRoot();
    }

    public boolean respuesta(){
        boolean respu=false;
        int index = icoBinding.radiogroup.getCheckedRadioButtonId();
        if(index==2131231070){
            respu=true;
        }
        return respu;
    }
}