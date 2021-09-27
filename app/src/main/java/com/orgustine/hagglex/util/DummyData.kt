package com.orgustine.hagglex.util

import com.orgustine.hagglex.data.mdel.DoMore
import com.orgustine.hagglex.data.mdel.Market
import com.orgustine.hagglex.R
import com.orgustine.hagglex.data.mdel.TrendingNews

object DummyData {
    val marketList = arrayListOf(
        Market(R.drawable.hag_ic, "Haggle (HAG)","NGN 380", "", R.drawable.chart_ic),
        Market(R.drawable.ic_bitlogo, "Bitcoin (BTC)","NGN 4,2,147.00", "+2.34%", R.drawable.grp_btc),
        Market(R.drawable.ic_ethereum_eth, "Ethereum (ETH)","NGN 4,2,147.00", "+2.34%", R.drawable.grp_eth),
        Market(R.drawable.ic_usdt, "Tether (USDT)","NGN 4,2,147.00", "+2.34%", R.drawable.grp_usdt),
        Market(R.drawable.ic_bitcash, "Bitcoin Cash (BCH)","NGN 4,2,147.00", "+2.34%", R.drawable.grp_btccash),
        Market(R.drawable.ic_dogecoin, "Dogecoin (DOGE)","NGN 4,2,147.00", "+2.34%", R.drawable.grp_doge),
        Market(R.drawable.ic_litecoin, "Litecoin (BCH)","NGN 4,2,147.00", "+2.34%", R.drawable.grp_ltc),
        )

    val newsList = arrayListOf(
        TrendingNews(R.drawable.btc_img, "Blockchain Bites: BTC on Ethereum, DeFi’s latest stablecoin, the currency cold wars","6hrs ago", "DeFi"),
        TrendingNews(R.drawable.btc_img, "Blockchain Bites: BTC on Ethereum, DeFi’s latest stablecoin, the currency cold wars","6hrs ago", "DeFi"),
        TrendingNews(R.drawable.btc_img, "Blockchain Bites: BTC on Ethereum, DeFi’s latest stablecoin, the currency cold wars","6hrs ago", "DeFi"),
        TrendingNews(R.drawable.btc_img, "Blockchain Bites: BTC on Ethereum, DeFi’s latest stablecoin, the currency cold wars","6hrs ago", "DeFi"),
        TrendingNews(R.drawable.btc_img, "Blockchain Bites: BTC on Ethereum, DeFi’s latest stablecoin, the currency cold wars","6hrs ago", "DeFi"),
    )

    val doMoreList = arrayListOf(
        DoMore(R.drawable.send_ic, "Send money instantly","Send crypto to another wallet"),
        DoMore(R.drawable.recieve_ic, "Receive money from anyone","Receive crypto from another wallet"),
        DoMore(R.drawable.ic_card, "Virtual Card","Make faster payments using HaggleX cards"),
        DoMore(R.drawable.back_btn, "Global Remittance","Send money to anyone, anywhere"),
    )

    var vplist = arrayListOf(R.drawable.pager2, R.drawable.pager3, R.drawable.pager4)

}