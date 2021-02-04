package com.miguel_santos.com.example.lgc_thiengo_copia.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.miguel_santos.com.example.lgc_thiengo_copia.ComercioActivity;
import com.miguel_santos.com.example.lgc_thiengo_copia.R;
import com.miguel_santos.com.example.lgc_thiengo_copia.domain.Comentario;
import com.miguel_santos.com.example.lgc_thiengo_copia.domain.Comercio;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class ComerciosAdapter extends RecyclerView.Adapter<ComerciosAdapter.ViewHolder>{

    private List<Comercio> comercios;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView ivPrincipal;
        TextView tvNomeFantasia;
        TextView tvLocalizacao;
        TextView tvAvaliacaoPontos;
        TextView tvAvaliacaoQtd;
        CircularImageView ivComentario1;
        TextView tvComentario1;
        CircularImageView ivComentario2;
        TextView tvComentario2;
        CircularImageView ivComentario3;
        TextView tvComentario3;
        ImageView ivEstrela1;
        ImageView ivEstrela2;
        ImageView ivEstrela3;
        ImageView ivEstrela4;
        ImageView ivEstrela5;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            ivPrincipal = itemView.findViewById(R.id.iv_principal);
            tvNomeFantasia = itemView.findViewById(R.id.tv_nome_fantasia);
            tvLocalizacao = itemView.findViewById(R.id.tv_localizacao);
            tvAvaliacaoPontos = itemView.findViewById(R.id.tv_avaliacao_pontos);
            tvAvaliacaoQtd = itemView.findViewById(R.id.tv_avaliacao_qtd);
            ivComentario1 = itemView.findViewById(R.id.iv_comentario_1);
            tvComentario1 = itemView.findViewById(R.id.tv_comentario_1);
            ivComentario2 = itemView.findViewById(R.id.iv_comentario_2);
            tvComentario2 = itemView.findViewById(R.id.tv_comentario_2);
            ivComentario3 = itemView.findViewById(R.id.iv_comentario_3);
            tvComentario3 = itemView.findViewById(R.id.tv_comentario_3);
            ivEstrela1 = itemView.findViewById(R.id.iv_estrela_1);
            ivEstrela2 = itemView.findViewById(R.id.iv_estrela_2);
            ivEstrela3 = itemView.findViewById(R.id.iv_estrela_3);
            ivEstrela4 = itemView.findViewById(R.id.iv_estrela_4);
            ivEstrela5 = itemView.findViewById(R.id.iv_estrela_5);
        }

        private void setData(Comercio comercio) {
            ivPrincipal.setImageResource(comercio.getImagem());
            tvNomeFantasia.setText(comercio.getNomeFantasia());
            tvLocalizacao.setText(comercio.getLocalizacao());
            tvAvaliacaoPontos.setText(String.format("%.1f", comercio.getAvaliacaoPontos()));
            tvAvaliacaoQtd.setText("("+ String.valueOf(comercio.getAvaliacaoQtd()+")"));
            setEstrelasAvaliacao(comercio);
            setComentarios(comercio);
        }

        private void setComentarios(Comercio comercio) {
            setComentario(ivComentario1, tvComentario1, comercio, 0);


        }

        private void setComentario(CircularImageView civPerfil, TextView tvMensagem, Comercio comercio, int position) {
            if (comercio.getComentarios().size() >= (position + 1)) {
                Comentario comentario = comercio.getComentarios().get(position);
                civPerfil.setImageResource(comentario.getUser().getImagem());
                tvMensagem.setText(comentario.getMensagem());
            } else {
                civPerfil.setVisibility(View.GONE);
                tvMensagem.setVisibility(View.GONE);
            }
        }

        private void setEstrelasAvaliacao(Comercio comercio) {
            setEstrela(ivEstrela1, 1, comercio);
            setEstrela(ivEstrela2, 2, comercio);
            setEstrela(ivEstrela3, 3, comercio);
            setEstrela(ivEstrela4, 4, comercio);
            setEstrela(ivEstrela5, 5, comercio);
        }

        private void setEstrela(ImageView ivEstrela, int posicaoEstrela, Comercio comercio) {
            if(posicaoEstrela <= (int) comercio.getAvaliacaoPontos()) {
                ivEstrela.setImageResource(R.drawable.ic_estrela);
            } else if (posicaoEstrela > comercio.getAvaliacaoPontos()
            && posicaoEstrela - 1 < comercio.getAvaliacaoPontos()) {
                ivEstrela.setImageResource(R.drawable.ic_estrela_metade);
            } else {
                ivEstrela.setImageResource(R.drawable.ic_estrela_vazia);
            }
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), ComercioActivity.class);
            intent.putExtra(Comercio.COMERCIO_SELECIONADO_KEY, comercios.get(getAdapterPosition()));
            v.getContext().startActivity(intent);
        }

    }

    public ComerciosAdapter(List<Comercio> comercios) {
        this.comercios =comercios;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comercio, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.setData(comercios.get(position));
    }

    @Override
    public int getItemCount() {
        return comercios.size();
    }

}
