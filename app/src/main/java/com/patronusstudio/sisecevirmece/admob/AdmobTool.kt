package com.patronusstudio.sisecevirmece.admob

import android.content.Context
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.reward.RewardItem
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.reward.RewardedVideoAdListener
import com.patronusstudio.sisecevirmece.R

class AdmobTool(val mContext: Context, val isSucces: (Boolean, message: String) -> Unit) :
    RewardedVideoAdListener {

    private var mRewardedVideoAd: RewardedVideoAd = MobileAds.getRewardedVideoAdInstance(mContext)

    init {
        mRewardedVideoAd.rewardedVideoAdListener = this
    }

    fun loadAd() {
//        mRewardedVideoAd.loadAd("ca-app-pub-1818679104699845/8964537567",
//            AdRequest.Builder().build())
        mRewardedVideoAd.loadAd(
            "ca-app-pub-3940256099942544/5224354917",
            AdRequest.Builder().build()
        )
        //todo : reklam idsini değiştirmeyi unutma.Ekli olan test id
    }

    override fun onRewardedVideoAdClosed() {
    }

    override fun onRewardedVideoAdLeftApplication() {
        isSucces(false, mContext.getString(R.string.uygulamadan_cikildi))
    }

    override fun onRewardedVideoAdLoaded() {
        mRewardedVideoAd.show()
    }

    override fun onRewardedVideoAdOpened() {
    }

    override fun onRewardedVideoCompleted() {
    }

    override fun onRewarded(p0: RewardItem?) {
        isSucces(true, mContext.getString(R.string.odul_alindi))
    }

    override fun onRewardedVideoStarted() {
    }

    override fun onRewardedVideoAdFailedToLoad(p0: Int) {
        isSucces(false, mContext.getString(R.string.reklam_yuklenemedi))
    }

    fun pauseAd() {
        mRewardedVideoAd.pause(mContext)
    }

    fun resumeAd() {
        mRewardedVideoAd.resume(mContext)
    }

    fun destroyAd() {
        mRewardedVideoAd.destroy(mContext)
    }

}