package com.ojanbelajar.obuce.ui.tab.home.dictionary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ojanbelajar.obuce.data.source.local.entity.DictionaryEntity
import com.ojanbelajar.obuce.databinding.ActivityDictionaryFoodBinding

class DictionaryFoodActivity: AppCompatActivity() {

    lateinit var binding: ActivityDictionaryFoodBinding
    private var data = ArrayList<DictionaryEntity>()
    lateinit var adapter: DictionaryFoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDictionaryFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        data.add(DictionaryEntity("Calories","coba kita bedah satu-satu yak, di situ ada app:behavior_hideable=”true” kode ini artinya layout bottom sheet kita memiliki kemampuan buat bisa di sembunyikan. Selanjutnya app:behavior_peekHeight=”56dp” kode ini aritnya tinggi layout yang bakal keliatan pas awal itu 56dp, ini bisa kalian sesuaiin juga, tapi dokumentasi material desain merekomendasikan 56dp. Oke yang terakhir itu app:layout_behavior kode ini buat jadiin ConstraintLayout kita memiliki sifat dari bottom sheet material desain dengan nambahin com.google.android.material.bottomsheet.BottomSheetBehavior sebagai parameter. Ada satu komponen text juga belum kita definisikan yaitu android:text=”@string/contact_me” kita coba isi dengan value “Contact me” pada file style.xml.\n" +
                "Oke lanjut kita lengkapi layout di activity_main.xml biar jadi seperti ini.Layout activity_main.xml kita berisiikan 2 komponen yaitu ImageView dan Button yang masing-masing kita lapisi dengan CardView, di mana CardView yang pertama bakal ngebungkus ImageView dan bikin gambar di dalamnya jadi bentuknya lingkaran. Sedangkan Button kita pake TextView yang dibungkus CardView juga, biar kece gitu.\n" +
                "Untuk lebih detail tentang Custom Shape ImageView dengan CardView bisa baca disini ya.Jadi pada kelas model kita kali ini berisikan 3 atribut yaitu img, text, dan url. img ini akan berisikan url gambar icon buat item kita, text adalah judul itemnya, sementara url adalah url dari item yang bakal di tuju seperti akun instagram atau github kita.\n" +
                "Lanjut kita buat adapter list di bottom seet kita, buat kelas baru namanya DialogAdapter, habis itu lengkapi jadi seperti ini.\nNah di tahap ini yang penting buat paham cara bikin Bottom Sheet Dialog, coba perhtaikan ketika callback setOnClickListener milik btnShare. Coba kita pahami langkah-langkahnya.\n" +
                "Inflate layout bottom sheetnya. cara inflate layout ada di line 44, disana ada varibel view yang menampung layout inflaternya."))
        data.add(DictionaryEntity("Calories","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "\n" +
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem."))
        data.add(DictionaryEntity("Calories","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "\n" +
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem."))
        data.add(DictionaryEntity("Calories","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "\n" +
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem."))
        data.add(DictionaryEntity("Calories","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "\n" +
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem."))

        adapter = DictionaryFoodAdapter(data,this)
        binding.back.setOnClickListener {
            finish()
        }
        setRv()
    }



    fun setRv(){
        binding.rvDictionary.layoutManager = LinearLayoutManager(this)
        binding.rvDictionary.adapter = adapter
    }
}