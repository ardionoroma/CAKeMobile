package com.smti08.cakemobile;

import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterDaftar adapterDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setPadding(10,10,10,10);
        SpacesItemDecoration space = new SpacesItemDecoration(1);
        recyclerView.addItemDecoration(space);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapterDaftar = new AdapterDaftar();
        recyclerView.setAdapter(adapterDaftar);
    }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;
            outRect.top = space;
        }
    }

    class AdapterDaftar extends RecyclerView.Adapter<AdapterDaftar.viewHolder>{

        AdapterDaftar(){
            notifyDataSetChanged();
        }

        @Override
        public AdapterDaftar.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, null);
            return new viewHolder(itemLayout);
        }

        @Override
        public void onBindViewHolder(viewHolder holder, int position) {
            switch(position){
                case 0:
                    holder.ikon.setImageResource(R.drawable.adhi);
                    holder.nama.setText("PT. Adhi Karya (Persero) Tbk.");
                    holder.deskripsi.setText("PT Adhi Karya Tbk (ADHI) adalah perusahaan yang bergerak di bidang konstruksi di Indonesia. Terhitung sejak tanggal 1 Juni 1974, ADHI menjadi Perseroan Terbatas, berdasarkan pengesahan Menteri Kehakiman Republik Indonesia. Perusahaan ini merupakan perusahaan konstruksi pertama yang terdaftar di Bursa Efek Indonesia (d.h. Bursa Efek Jakarta) sejak 18 Maret 2004, di mana pada akhir tahun 2003 negara Republik Indonesia telah melepas 49% kepemilikan sahamnya kepada masyarakat melalui mekanisme Initial Public Offering (IPO).");
                    holder.harga.setText("Rp 1.870,00");
                    break;
                case 1:
                    holder.ikon.setImageResource(R.drawable.bri);
                    holder.nama.setText("PT Bank Rakyat Indonesia (Persero) Tbk.");
                    holder.deskripsi.setText("Bank Rakyat Indonesia (BRI) merupakan salah satu bank milik pemerintah terbesar di Indonesia. Sejak dikeluarkannya Undang-Undang Perbankan Nomor 7 Tahun 1992 dan Peraturan Pemerintah R.I. Nomor 21 tahun 1992 status BRI menjadi perseroan terbatas sejak tanggal 1 Agustus 1992. Pada tahun 2003, Pemerintah Indonesia menjual 30% saham BRI sehingga resmi berganti menjadi PT Bank Rakyat Indonesia (Persero) yang sampai sekarang menjadi bank pilihan nasabah.");
                    holder.harga.setText("Rp 3.160,00");
                    break;
                case 2:
                    holder.ikon.setImageResource(R.drawable.telkom);
                    holder.nama.setText("PT Telekomunikasi Indonesia (Persero) Tbk.");
                    holder.deskripsi.setText("PT. Telekomunikasi Indonesia, Tbk, (Telkom) adalah BUMN yang bergerak di bidang jasa layanan telekomunikasi dan jaringan di wilayah Indonesia. Saat ini sahamnya dimiliki oleh Pemerintah Indonesia (53,6%), dan 46,4% dimiliki oleh Publik, Bank of New York, dan Investor dalam Negeri. Telkom mempunyai 13 anak perusahaan. Telkom telah melayani lebih dari 151,9 juta pelanggan yang terdiri dari seluler (Telkomsel) lebih dari 125 juta dan pelanggan tetap 25,8 juta. Perusahaan ini menyediakan berbagai layanan komunikasi lainnya termasuk interkoneksi jaringan telepon, multimedia, data dan layanan terkait komunikasi internet, sewa transponder satelit, sirkit langganan, televisi berbayar dan layanan VoIP. Perusahaan yang memiliki visi menjadi perusahaan yang unggul dalam penyelenggaraan Telecommunication, Information, Media, Edutainment dan Services (“TIMES”) di kawasan regional ini telah mendominasi lebih dari 60 persen pangsa pasar broadband Indonesia. Artinya Telkom sudah memiliki lebih dari 19 juta pelanggan broadband. Telkom memiliki kapasitas gateway internet lebih dari 106,4 Gbps. Perusahaan ini selalu berusaha memastikan kecukupan gateway internet guna memenuhi kebutuhan konsumen baik dari fixed broadband maupun mobile broadband. Telkom juga berkembang melalui anak perusahaan antara lain PT Telekomunikasi Selular (Telkomsel), PT Multimedia Nusantara (Metra), PT Telekomunikasi Indonesia International (TII/Telin), PT PINS Indonesia (PINS/Pramindo), PT Infomedia Nusantara (Infomedia), PT Dayamitra Telekomunikasi (Mitratel/Dayamitra), PT Indonusa Telemedia (TelkomVision), PT Graha Sarana Duta (TelkomProperty/GSD), dan PT Napsindo Primatel Internasional (Napsindo). Pada pertengahan tahun 2013, Telkom Grup akan membangun Device-Network-Application (DNA) guna melahirkan teknologi broadband dengan kualitas baik di Indonesia. Dengan ini nantinya Telkom akan membawa negara Indonesia menjadi negara maju dalam teknologi informasi di dunia melalui teknologi broadband-nya.");
                    holder.harga.setText("Rp 3.750,00");
                    break;
                case 3:
                    holder.ikon.setImageResource(R.drawable.unilever);
                    holder.nama.setText("PT Unilever Indonesia Tbk.");
                    holder.deskripsi.setText("Unilever adalah perusahaan multinasional yang menghasilkan barang konsumen. Perusahaan ini bermarkas di Rotterdam, Belanda sejak tahun 1930. Produk yang dihasilkan mulai dari makanan, minuman, pembersih dan perlengkapan pribadi. Beberapa merek yang terkenal antara lain Rinso, Sunsilk, Dove dan Clear. Lebih dari dua miliar masyarakat yang menggunakan produk dari Unilever. Dengan lebih dari 400 merek difokuskan pada kesehatan dan kesejahteraan, tidak ada perusahaan menyentuh kehidupan begitu banyak orang dalam berbagai cara. Di sisi lain, misi korporasi adalah untuk meningkatkan vitalitas hidup. Hal ini menunjukkan bagaimana perusahaan benar-benar memahami pelanggan abad 21 dan kehidupan mereka. Banyak merek Unilever yang memiliki misi sosial, seperti Lifebuoy untuk mempromosikan kebersihan melalui cuci tangan dengan sabun, dan kampanye Dove untuk keindahan yang nyata. Unilever memiliki 14 merek dengan penjualan lebih dari 1 miliar euro per tahun. Perusahaan yang memiliki Lebih dari 173.000 ini menjadi perusahaan nomor satu yang bergerak dalam barang konsumen yang dipilih dari 20 negara. Unilever adalah perusahaan yang peduli terhadap lingkungan. Jejak gas rumah kaca dari penggunaan produk perusahaan telah berkurang sekitar 6% sejak 2010.");
                    holder.harga.setText("Rp 46.350,00");
                    break;
                case 4:
                    holder.ikon.setImageResource(R.drawable.adhi);
                    holder.nama.setText("PT. Adhi Karya (Persero) Tbk.");
                    holder.deskripsi.setText("PT Adhi Karya Tbk (ADHI) adalah perusahaan yang bergerak di bidang konstruksi di Indonesia. Terhitung sejak tanggal 1 Juni 1974, ADHI menjadi Perseroan Terbatas, berdasarkan pengesahan Menteri Kehakiman Republik Indonesia. Perusahaan ini merupakan perusahaan konstruksi pertama yang terdaftar di Bursa Efek Indonesia (d.h. Bursa Efek Jakarta) sejak 18 Maret 2004, di mana pada akhir tahun 2003 negara Republik Indonesia telah melepas 49% kepemilikan sahamnya kepada masyarakat melalui mekanisme Initial Public Offering (IPO).");
                    holder.harga.setText("Rp 1.870,00");
                    break;
                case 5:
                    holder.ikon.setImageResource(R.drawable.bri);
                    holder.nama.setText("PT Bank Rakyat Indonesia (Persero) Tbk.");
                    holder.deskripsi.setText("Bank Rakyat Indonesia (BRI) merupakan salah satu bank milik pemerintah terbesar di Indonesia. Sejak dikeluarkannya Undang-Undang Perbankan Nomor 7 Tahun 1992 dan Peraturan Pemerintah R.I. Nomor 21 tahun 1992 status BRI menjadi perseroan terbatas sejak tanggal 1 Agustus 1992. Pada tahun 2003, Pemerintah Indonesia menjual 30% saham BRI sehingga resmi berganti menjadi PT Bank Rakyat Indonesia (Persero) yang sampai sekarang menjadi bank pilihan nasabah.");
                    holder.harga.setText("Rp 3.160,00");
                    break;
                case 6:
                    holder.ikon.setImageResource(R.drawable.telkom);
                    holder.nama.setText("PT Telekomunikasi Indonesia (Persero) Tbk.");
                    holder.deskripsi.setText("PT. Telekomunikasi Indonesia, Tbk, (Telkom) adalah BUMN yang bergerak di bidang jasa layanan telekomunikasi dan jaringan di wilayah Indonesia. Saat ini sahamnya dimiliki oleh Pemerintah Indonesia (53,6%), dan 46,4% dimiliki oleh Publik, Bank of New York, dan Investor dalam Negeri. Telkom mempunyai 13 anak perusahaan. Telkom telah melayani lebih dari 151,9 juta pelanggan yang terdiri dari seluler (Telkomsel) lebih dari 125 juta dan pelanggan tetap 25,8 juta. Perusahaan ini menyediakan berbagai layanan komunikasi lainnya termasuk interkoneksi jaringan telepon, multimedia, data dan layanan terkait komunikasi internet, sewa transponder satelit, sirkit langganan, televisi berbayar dan layanan VoIP. Perusahaan yang memiliki visi menjadi perusahaan yang unggul dalam penyelenggaraan Telecommunication, Information, Media, Edutainment dan Services (“TIMES”) di kawasan regional ini telah mendominasi lebih dari 60 persen pangsa pasar broadband Indonesia. Artinya Telkom sudah memiliki lebih dari 19 juta pelanggan broadband. Telkom memiliki kapasitas gateway internet lebih dari 106,4 Gbps. Perusahaan ini selalu berusaha memastikan kecukupan gateway internet guna memenuhi kebutuhan konsumen baik dari fixed broadband maupun mobile broadband. Telkom juga berkembang melalui anak perusahaan antara lain PT Telekomunikasi Selular (Telkomsel), PT Multimedia Nusantara (Metra), PT Telekomunikasi Indonesia International (TII/Telin), PT PINS Indonesia (PINS/Pramindo), PT Infomedia Nusantara (Infomedia), PT Dayamitra Telekomunikasi (Mitratel/Dayamitra), PT Indonusa Telemedia (TelkomVision), PT Graha Sarana Duta (TelkomProperty/GSD), dan PT Napsindo Primatel Internasional (Napsindo). Pada pertengahan tahun 2013, Telkom Grup akan membangun Device-Network-Application (DNA) guna melahirkan teknologi broadband dengan kualitas baik di Indonesia. Dengan ini nantinya Telkom akan membawa negara Indonesia menjadi negara maju dalam teknologi informasi di dunia melalui teknologi broadband-nya.");
                    holder.harga.setText("Rp 3.750,00");
                    break;
                case 7:
                    holder.ikon.setImageResource(R.drawable.unilever);
                    holder.nama.setText("PT Unilever Indonesia Tbk.");
                    holder.deskripsi.setText("Unilever adalah perusahaan multinasional yang menghasilkan barang konsumen. Perusahaan ini bermarkas di Rotterdam, Belanda sejak tahun 1930. Produk yang dihasilkan mulai dari makanan, minuman, pembersih dan perlengkapan pribadi. Beberapa merek yang terkenal antara lain Rinso, Sunsilk, Dove dan Clear. Lebih dari dua miliar masyarakat yang menggunakan produk dari Unilever. Dengan lebih dari 400 merek difokuskan pada kesehatan dan kesejahteraan, tidak ada perusahaan menyentuh kehidupan begitu banyak orang dalam berbagai cara. Di sisi lain, misi korporasi adalah untuk meningkatkan vitalitas hidup. Hal ini menunjukkan bagaimana perusahaan benar-benar memahami pelanggan abad 21 dan kehidupan mereka. Banyak merek Unilever yang memiliki misi sosial, seperti Lifebuoy untuk mempromosikan kebersihan melalui cuci tangan dengan sabun, dan kampanye Dove untuk keindahan yang nyata. Unilever memiliki 14 merek dengan penjualan lebih dari 1 miliar euro per tahun. Perusahaan yang memiliki Lebih dari 173.000 ini menjadi perusahaan nomor satu yang bergerak dalam barang konsumen yang dipilih dari 20 negara. Unilever adalah perusahaan yang peduli terhadap lingkungan. Jejak gas rumah kaca dari penggunaan produk perusahaan telah berkurang sekitar 6% sejak 2010.");
                    holder.harga.setText("Rp 46.350,00");
                    break;
                case 8:
                    holder.ikon.setImageResource(R.drawable.adhi);
                    holder.nama.setText("PT. Adhi Karya (Persero) Tbk.");
                    holder.deskripsi.setText("PT Adhi Karya Tbk (ADHI) adalah perusahaan yang bergerak di bidang konstruksi di Indonesia. Terhitung sejak tanggal 1 Juni 1974, ADHI menjadi Perseroan Terbatas, berdasarkan pengesahan Menteri Kehakiman Republik Indonesia. Perusahaan ini merupakan perusahaan konstruksi pertama yang terdaftar di Bursa Efek Indonesia (d.h. Bursa Efek Jakarta) sejak 18 Maret 2004, di mana pada akhir tahun 2003 negara Republik Indonesia telah melepas 49% kepemilikan sahamnya kepada masyarakat melalui mekanisme Initial Public Offering (IPO).");
                    holder.harga.setText("Rp 1.870,00");
                    break;
                case 9:
                    holder.ikon.setImageResource(R.drawable.bri);
                    holder.nama.setText("PT Bank Rakyat Indonesia (Persero) Tbk.");
                    holder.deskripsi.setText("Bank Rakyat Indonesia (BRI) merupakan salah satu bank milik pemerintah terbesar di Indonesia. Sejak dikeluarkannya Undang-Undang Perbankan Nomor 7 Tahun 1992 dan Peraturan Pemerintah R.I. Nomor 21 tahun 1992 status BRI menjadi perseroan terbatas sejak tanggal 1 Agustus 1992. Pada tahun 2003, Pemerintah Indonesia menjual 30% saham BRI sehingga resmi berganti menjadi PT Bank Rakyat Indonesia (Persero) yang sampai sekarang menjadi bank pilihan nasabah.");
                    holder.harga.setText("Rp 3.160,00");
                    break;
                case 10:
                    holder.ikon.setImageResource(R.drawable.telkom);
                    holder.nama.setText("PT Telekomunikasi Indonesia (Persero) Tbk.");
                    holder.deskripsi.setText("PT. Telekomunikasi Indonesia, Tbk, (Telkom) adalah BUMN yang bergerak di bidang jasa layanan telekomunikasi dan jaringan di wilayah Indonesia. Saat ini sahamnya dimiliki oleh Pemerintah Indonesia (53,6%), dan 46,4% dimiliki oleh Publik, Bank of New York, dan Investor dalam Negeri. Telkom mempunyai 13 anak perusahaan. Telkom telah melayani lebih dari 151,9 juta pelanggan yang terdiri dari seluler (Telkomsel) lebih dari 125 juta dan pelanggan tetap 25,8 juta. Perusahaan ini menyediakan berbagai layanan komunikasi lainnya termasuk interkoneksi jaringan telepon, multimedia, data dan layanan terkait komunikasi internet, sewa transponder satelit, sirkit langganan, televisi berbayar dan layanan VoIP. Perusahaan yang memiliki visi menjadi perusahaan yang unggul dalam penyelenggaraan Telecommunication, Information, Media, Edutainment dan Services (“TIMES”) di kawasan regional ini telah mendominasi lebih dari 60 persen pangsa pasar broadband Indonesia. Artinya Telkom sudah memiliki lebih dari 19 juta pelanggan broadband. Telkom memiliki kapasitas gateway internet lebih dari 106,4 Gbps. Perusahaan ini selalu berusaha memastikan kecukupan gateway internet guna memenuhi kebutuhan konsumen baik dari fixed broadband maupun mobile broadband. Telkom juga berkembang melalui anak perusahaan antara lain PT Telekomunikasi Selular (Telkomsel), PT Multimedia Nusantara (Metra), PT Telekomunikasi Indonesia International (TII/Telin), PT PINS Indonesia (PINS/Pramindo), PT Infomedia Nusantara (Infomedia), PT Dayamitra Telekomunikasi (Mitratel/Dayamitra), PT Indonusa Telemedia (TelkomVision), PT Graha Sarana Duta (TelkomProperty/GSD), dan PT Napsindo Primatel Internasional (Napsindo). Pada pertengahan tahun 2013, Telkom Grup akan membangun Device-Network-Application (DNA) guna melahirkan teknologi broadband dengan kualitas baik di Indonesia. Dengan ini nantinya Telkom akan membawa negara Indonesia menjadi negara maju dalam teknologi informasi di dunia melalui teknologi broadband-nya.");
                    holder.harga.setText("Rp 3.750,00");
                    break;
                case 11:
                    holder.ikon.setImageResource(R.drawable.unilever);
                    holder.nama.setText("PT Unilever Indonesia Tbk.");
                    holder.deskripsi.setText("Unilever adalah perusahaan multinasional yang menghasilkan barang konsumen. Perusahaan ini bermarkas di Rotterdam, Belanda sejak tahun 1930. Produk yang dihasilkan mulai dari makanan, minuman, pembersih dan perlengkapan pribadi. Beberapa merek yang terkenal antara lain Rinso, Sunsilk, Dove dan Clear. Lebih dari dua miliar masyarakat yang menggunakan produk dari Unilever. Dengan lebih dari 400 merek difokuskan pada kesehatan dan kesejahteraan, tidak ada perusahaan menyentuh kehidupan begitu banyak orang dalam berbagai cara. Di sisi lain, misi korporasi adalah untuk meningkatkan vitalitas hidup. Hal ini menunjukkan bagaimana perusahaan benar-benar memahami pelanggan abad 21 dan kehidupan mereka. Banyak merek Unilever yang memiliki misi sosial, seperti Lifebuoy untuk mempromosikan kebersihan melalui cuci tangan dengan sabun, dan kampanye Dove untuk keindahan yang nyata. Unilever memiliki 14 merek dengan penjualan lebih dari 1 miliar euro per tahun. Perusahaan yang memiliki Lebih dari 173.000 ini menjadi perusahaan nomor satu yang bergerak dalam barang konsumen yang dipilih dari 20 negara. Unilever adalah perusahaan yang peduli terhadap lingkungan. Jejak gas rumah kaca dari penggunaan produk perusahaan telah berkurang sekitar 6% sejak 2010.");
                    holder.harga.setText("Rp 46.350,00");
                    break;
            }
        }

        @Override
        public int getItemCount() {
            return 12;
        }

        class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            TextView nama, deskripsi, harga;
            ImageView ikon;

            public viewHolder(View itemView){
                super(itemView);
                itemView.setOnClickListener(this);
                ikon = itemView.findViewById(R.id.ikon);
                nama = itemView.findViewById(R.id.nama);
                deskripsi = itemView.findViewById(R.id.deskripsi);
                harga = itemView.findViewById(R.id.harga);
            }
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CategoryActivity.this, DetailActivity.class);
                startActivity(i);
            }
        }
    }
}
