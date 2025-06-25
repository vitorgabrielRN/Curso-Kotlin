package br.com.prodiga

data class InfoJogo(val info:InfoApiShark) {
    override fun toString(): String {
        return info.toString()
    }
}