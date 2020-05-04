package com.frappeclub.sisecevirmece.mock

object Questions {

    private val _dogrulukSoruListesi = ArrayList<String>()
    val dogrulukSoruListesi
        get() = _dogrulukSoruListesi

    private val _cesaretSoruListesi = ArrayList<String>()
    val cesaretSoruListesi
        get() = _cesaretSoruListesi

    //Todo : Bu sınıfta gereksiz kodlar var.Bunlar düzeltilecek.
    fun listeEkleDogruluk() {
        _dogrulukSoruListesi.add("Soru1")
        _dogrulukSoruListesi.add("Soru2")
        _dogrulukSoruListesi.add("Soru3")
        _dogrulukSoruListesi.add("Soru4")
        _dogrulukSoruListesi.add("Soru5")
        _dogrulukSoruListesi.add("Soru6")
    }

    fun listeEkleCesaret() {
        _cesaretSoruListesi.add("Soru1")
        _cesaretSoruListesi.add("Soru2")
        _cesaretSoruListesi.add("Soru3")
        _cesaretSoruListesi.add("Soru4")
        _cesaretSoruListesi.add("Soru5")
        _cesaretSoruListesi.add("Soru6")
    }

    fun getSoru(listeTuru: ArrayList<String>): String {

        if (listeTuru.isEmpty()) {
            if (listeTuru == _dogrulukSoruListesi) listeEkleDogruluk()
            else listeEkleCesaret()
        }

        listeTuru.shuffle()
        return listeTuru[0]
    }

    fun removeSoru(listeTuru: ArrayList<String>) {

        if (listeTuru.size > 1) {
            listeTuru.removeAt(0)
            return
        } else {
            if (listeTuru == _dogrulukSoruListesi) {
                listeEkleDogruluk()
            } else {
                listeEkleCesaret()
            }
        }
    }

}