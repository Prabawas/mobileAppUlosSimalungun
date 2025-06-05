package com.example.mydetectionapp.ui.mainScreen.ulosDetail

//import android.R
import com.example.mydetectionapp.R


data class Ulos(
    val name: String,
    val description: String,
    val usage: String,
    val howToWear: String,
    val meaning: String,
    val extraInfo: String,
    val imageRes1: Int,
    val imageRes2: Int,
    val howToWearImageRes1: Int,
    val howToWearImageRes2: Int
)

val ulosListData = listOf(
    Ulos(
        name = "Ulos Bittang Maratur",
        description = "Ulos ini digunakan dalam beberapa ritual seperti pemulihan bagi seseorang yang sedang sakit, pengantin baru, dan penempatan rumah baru dengan harapan membawa keberkahan dan mencegah kejadian serupa terulang. Selain itu, Ulos Bittang Maratur adalah salah satu jenis ulos Simalungun yang memiliki popularitas tinggi berkat keindahan hiasan estetikanya.",
        usage = "Diberikan dalam upacara adat pernikahan oleh paman sebagai tanda restu untuk pengantin baru, serta digunakan dalam acara syukuran rumah baru dan berbagai kegiatan adat penting lainnya.",
        howToWear = "Biasanya diselendangkan di pundak penerima ulos, atau dalam konteks acara pernikahan bisa dikenakan oleh pengantin di atas pakaian adat mereka.",
        meaning = "Melambangkan doa untuk kesehatan, keberkahan, restu, dan kelangsungan kehidupan yang penuh kesejahteraan.",
        extraInfo = "Seiring perkembangan zaman, Ulos Bittang Maratur tetap mempertahankan pola tradisionalnya, namun mulai bermunculan variasi warna dan motif tambahan agar lebih menarik bagi generasi muda, tanpa menghilangkan makna filosofis aslinya.",
        imageRes1 = R.drawable.detail_0_ulos_bittang_maratur_1,
        imageRes2 = R.drawable.detail_0_ulos_bittang_maratur_2,
        howToWearImageRes1 = R.drawable.tata_cara_bittang_maratur_1,
        howToWearImageRes2 = R.drawable.tata_cara_bittang_maratur_2
    ),
    Ulos(
        name = "Ulos Bulang",
        description = "Ulos Bulang adalah kain tradisional Simalungun yang digunakan sebagai penutup kepala oleh wanita, baik muda maupun tua, tanpa memandang status pernikahan. Kain ini melambangkan keseimbangan antara kehormatan dan perlindungan dalam kehidupan sosial dan spiritual masyarakat Simalungun.",
        usage = "Dipakai dalam upacara adat sebagai penutup kepala bagi para wanita yang mengenakan. Ulos Bulang juga diberikan dalam beberapa upacara seperti pernikahan, kelahiran, dan syukuran sebagai simbol penghargaan dan berkah.",
        howToWear = "Diletakkan di kepala dengan bagian kanan lebih tinggi dari bagian kiri, mengikuti aturan adat Simalungun.",
        meaning = "Mewakili perlindungan, kehormatan, keseimbangan hidup, serta berkah dari roh nenek moyang kepada pemakainya.",
        extraInfo = "Ulos Bulang biasanya berwarna merah, hitam, dan putih dengan motif geometris rumit, dibuat menggunakan teknik tenun tradisional dari benang kapas atau sutra berpewarna alami. Saat ini, ulos ini juga diaplikasikan dalam busana pengantin dan kerajinan tangan modern demi menjaga kelestarian salah satu budaya Simalungun.",
        imageRes1 = R.drawable.detail_1_ulos_bulang_1,
        imageRes2 = R.drawable.detail_1_ulos_bulang_2,
        howToWearImageRes1 = R.drawable.tata_cara_bulang_1,
        howToWearImageRes2 = R.drawable.tata_cara_bulang_2
    ),
    Ulos(
        name = "Ulos Hati Rongga",
        description = "Ulos Hati Rongga adalah kain tradisional Simalungun yang biasa digunakan oleh perempuan, khususnya sebagai jabit (sarung), terutama dalam upacara adat pernikahan. Kain ini dibuat dari benang kapas dengan dominasi warna merah dan garis-garis emas yang menambah keanggunannya.",
        usage = "Dipakai sebagai sarung (jabit) oleh wanita dalam upacara adat, khususnya pada pernikahan, untuk melambangkan kesucian, kehangatan, dan penghormatan kepada adat serta keluarga.",
        howToWear = "Dikenakan dengan cara dililitkan sebagai sarung di bagian pinggang, biasanya dipadukan dengan atasan tradisional khas Simalungun.",
        meaning = "Melambangkan semangat, keberanian, kehormatan, dan harapan akan kehidupan rumah tangga yang harmonis dan penuh berkat.",
        extraInfo = "Warna merah pada Ulos Hati Rongga melambangkan kekuatan dan cinta, sementara aksen emas melambangkan kemakmuran dan keagungan. Kain ini tidak hanya dipakai dalam upacara pernikahan, tetapi juga dalam acara adat besar lain sebagai simbol status dan penghormatan terhadap tradisi leluhur.",
        imageRes1 = R.drawable.detail_2_ulos_hati_rongga_1,
        imageRes2 = R.drawable.detail_2_ulos_hati_rongga_2,
        howToWearImageRes1 = R.drawable.tata_cara_hatirongga_1,
        howToWearImageRes2 = R.drawable.tata_cara_hatirongga_2
    ),
    Ulos(
        name = "Ulos Mangiring",
        description = "Ulos Mangiring adalah salah satu kain tradisional Batak Simalungun yang sering digunakan dalam upacara adat. Kain ini memiliki desain dan kombinasi warna yang menarik, melambangkan harapan dan doa keberuntungan serta perlindungan.",
        usage = "Diberikan kepada anak pertama yang baru lahir sebagai simbol harapan agar anak tersebut akan diiringi oleh saudara-saudara lainnya. Juga digunakan dalam berbagai upacara adat seperti pernikahan dan pertunangan.",
        howToWear = "Dikenakan sebagai selendang atau penutup kepala, tergantung pada konteks upacara dan peran individu dalam adat tersebut.",
        meaning = "Melambangkan kesuburan, keharmonisan keluarga, persatuan, dan harapan akan kehidupan yang sukses dan memuaskan.",
        extraInfo = "Nama 'Mangiring' berasal dari motif kain yang saling beriringan, mencerminkan harapan agar anak pertama akan diikuti oleh saudara-saudara lainnya. Kain ini sering digunakan sebagai 'ulos parompa' atau gendongan bayi, serta sebagai simbol perlindungan dan berkah dari leluhur.",
        imageRes1 = R.drawable.detail_3_ulos_mangiring_1,
        imageRes2 = R.drawable.detail_3_ulos_mangiring_2,
        howToWearImageRes1 = R.drawable.tata_cara_mangiring_1,
        howToWearImageRes2 = R.drawable.tata_cara_mangiring_2
    ),
    Ulos(
        name = "Ulos Ragi Idup",
        description = "Ulos Ragi Idup adalah kain tradisional Simalungun yang memiliki makna mendalam dalam kehidupan budaya masyarakatnya. Kain ini diberikan kepada menantu perempuan sebagai simbol penghormatan dan harapan agar ia menjadi penopang keluarga dalam menghadapi rintangan yang datang.",
        usage = "Diberikan kepada menantu perempuan oleh mertua dalam upacara adat pernikahan, melambangkan restu dan harapan agar menantu menjadi penopang keluarga.",
        howToWear = "Dikenakan sebagai selendang atau penutup tubuh bagian atas oleh menantu perempuan dalam upacara adat.",
        meaning = "Melambangkan kehidupan, keberkahan, dan harapan akan keturunan yang banyak serta keluarga yang harmonis.",
        extraInfo = "Ulos Ragi Idup memiliki warna putih di bagian tengah ujung kain yang dipadukan dengan warna merah hati sehingga memberikan kesan mewah dan megah. Pembuatan ulos ini sangat rumit karena terdapat tiga bagian tenun, yaitu dua sisi kain ditenun sekaligus, sedangkan bagian tengah ditenun tersendiri.",
        imageRes1 = R.drawable.detail_4_ulos_ragi_idup_1,
        imageRes2 = R.drawable.detail_4_ulos_ragi_idup_2,
        howToWearImageRes1 = R.drawable.tata_cara_bittang_maratur_1,
        howToWearImageRes2 = R.drawable.tata_cara_bittang_maratur_2
    ),
    Ulos(
        name = "Ulos Ragi Santik",
        description = "Ulos Ragi Santik adalah kain khas Simalungun yang mencerminkan kehormatan, kewibawaan, dan status sosial, dirancang dengan motif yang beragam dan perpaduan warna gelap yang elegan.",
        usage = "Sering dipakai oleh laki-laki dalam acara adat, pernikahan, dan upacara-upacara formal untuk memperlihatkan penghormatan terhadap tradisi dan leluhur.",
        howToWear = "Biasanya dikenakan menyerupai setengah sarung atau digunakan sebagai pelengkap busana adat resmi.",
        meaning = "Melambangkan kehormatan, keanggunan, koneksi spiritual dengan leluhur, serta kebanggaan terhadap warisan budaya Simalungun.",
        extraInfo = "Motif tenunan yang beragam dengan detail halus, mengkombinasikan warna-warna gelap yang menambah kesan sakral dan artistik; sering diwariskan antar generasi sebagai lambang keberlanjutan tradisi.",
        imageRes1 = R.drawable.detail_5_ulos_ragi_santik_1,
        imageRes2 = R.drawable.detail_5_ulos_ragi_santik_2,
        howToWearImageRes1 = R.drawable.tata_cara_ragi_santik_1,
        howToWearImageRes2 = R.drawable.tata_cara_ragi_santik_2
    ),
    Ulos(
        name = "Ulos Simangkat Angkat",
        description = "Ulos Simangkat Angkat adalah kain khas Simalungun yang dikenakan oleh laki-laki di bahu kanan pada upacara penting seperti pernikahan dan prosesi kematian. Ulos ini mencerminkan penghormatan dan penguatan hubungan keluarga.",
        usage = "Dipakai dalam upacara pernikahan untuk simbol restu dan dukungan keluarga kepada mempelai pria, serta dalam prosesi kematian sebagai penghormatan terakhir bagi anggota keluarga yang wafat.",
        howToWear = "Dikenakan dengan cara disampirkan di bahu kanan, memperlihatkan sikap hormat dan pengikatan hubungan antar keluarga dalam suasana suka maupun duka.",
        meaning = "Melambangkan restu, dukungan, ikatan kekeluargaan, penghormatan terhadap leluhur, serta ekspresi kesakralan dalam setiap tahapan hidup manusia.",
        extraInfo = "Motifnya menggunakan pola elegan dengan dominasi warna gelap, memperkuat kesan keagungan dan kesakralan; ulos ini memiliki posisi istimewa dalam mempererat tali persaudaraan antar marga di Simalungun.",
        imageRes1 = R.drawable.detail_6_ulos_simangkat_angkat_1,
        imageRes2 = R.drawable.detail_6_ulos_simangkat_angkat_2,
        howToWearImageRes1 = R.drawable.tata_cara_simangkat_1,
        howToWearImageRes2 = R.drawable.tata_cara_simangkat_2
    ),
    Ulos(
        name = "Ulos Sitoluntuho",
        description = "Ulos Sitoluntuho adalah kain khas Simalungun yang diberikan oleh orangtua kepada cucunya sebagai simbol kasih sayang, perlindungan, dan harapan akan masa depan yang sejahtera.",
        usage = "Diberikan kepada cucu sebagai pengganti kain gendongan bayi dalam acara adat atau momen-momen penting dalam memperkuat hubungan emosional antar generasi.",
        howToWear = "Digunakan sebagai selimut atau penutup tubuh bayi, atau disimpan sebagai warisan berharga dalam perjalanan hidup penerimanya.",
        meaning = "Melambangkan kasih sayang, perlindungan, kesejahteraan, harapan untuk kebahagiaan, serta kelanjutan hubungan antar generasi.",
        extraInfo = "Motif dan warna dipilih secara khusus untuk membawa doa dan restu keluarga besar; Ulos Sitoluntuho tidak hanya fungsional tetapi juga sakral, menjadi lambang eratnya nilai kekeluargaan.",
        imageRes1 = R.drawable.detail_7_ulos_sitoluntuho_1,
        imageRes2 = R.drawable.detail_7_ulos_sitoluntuho_2,
        howToWearImageRes1 = R.drawable.tata_cara_sitoluntuho_1,
        howToWearImageRes2 = R.drawable.tata_cara_sitoluntuho_2
    ),
    Ulos(
        name = "Ulos Suri-Suri",
        description = "Ulos Suri-Suri adalah kain adat Simalungun yang dikenakan di bahu kanan sebagai simbol identitas, status sosial, serta kekuatan spiritual, dengan motif geometris dan warna khas penuh makna.",
        usage = "Dipakai dalam berbagai upacara adat seperti pernikahan, kelahiran, kematian, dan keagamaan; juga berfungsi menandakan kedudukan sosial dalam masyarakat.",
        howToWear = "Dikenakan dengan disampirkan di bahu kanan, dililitkan atau diikat sesuai jenis acara, kadang juga digunakan di pinggang atau kepala tergantung tradisi yang berlaku.",
        meaning = "Melambangkan keberanian, kesedihan, harapan, dan kelestarian hubungan manusia dengan alam serta leluhur; menjadi identitas budaya dan spiritualitas masyarakat Simalungun.",
        extraInfo = "Motifnya mengadopsi pola alam, tumbuhan, dan hewan dengan filosofi mendalam; warna dominan seperti merah, hitam, putih, dan kuning membawa simbolisme kuat; beberapa Ulos Suri-Suri dibuat dari katun, sutra, bahkan disulam dengan benang emas atau perak untuk menunjukkan kemewahan.",
        imageRes1 = R.drawable.detail_8_ulos_suri_suri_1,
        imageRes2 = R.drawable.detail_8_ulos_suri_suri_2,
        howToWearImageRes1 = R.drawable.tata_cara_suri_suri,
        howToWearImageRes2 = R.drawable.tata_cara_suri_suri_1
    ),
    Ulos(
        name = "Ulos Tapak Catur",
        description = "Ulos Tapak Catur adalah kain ulos adat Simalungun yang dikenakan oleh perempuan, melambangkan keterikatan dengan nilai tradisi serta status sosial dalam berbagai upacara adat.",
        usage = "Dipakai oleh perempuan, baik yang sudah menikah maupun belum, dalam prosesi pernikahan dan acara-acara adat lainnya untuk menunjukkan kehormatan terhadap adat istiadat.",
        howToWear = "Dikenakan dengan cara dililitkan menjadi sarung menyerupai rok sehingga memperlihatkan kesan anggun dan bermartabat.",
        meaning = "Melambangkan keterikatan perempuan dengan nilai-nilai tradisi, kesetiaan terhadap adat, serta identitas sosial di masyarakat.",
        extraInfo = "Motifnya mengusung pola tapak atau jejak kaki yang sarat makna perjalanan hidup dan kontinuitas generasi; kain ini menjadi simbol kedewasaan, komitmen terhadap adat, dan kebanggaan budaya.",
        imageRes1 = R.drawable.detail_9_ulos_tapak_satur_1,
        imageRes2 = R.drawable.detail_9_ulos_tapak_satur_2,
        howToWearImageRes1 = R.drawable.tata_cara_tapakcatur_1,
        howToWearImageRes2 = R.drawable.tata_cara_tapakcatur_2
    )
)