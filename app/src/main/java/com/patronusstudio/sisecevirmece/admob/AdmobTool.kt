package com.patronusstudio.sisecevirmece.admob

import android.content.Context
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.reward.RewardItem
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.reward.RewardedVideoAdListener
import com.patronusstudio.sisecevirmece.R

class AdmobTool(
    val mContext: Context,
    val isSucces: (Boolean, message: String, isAdsClosed: Boolean) -> Unit
) :
    RewardedVideoAdListener {

    private var mRewardedVideoAd: RewardedVideoAd = MobileAds.getRewardedVideoAdInstance(mContext)
    var isClickShowAd = false
    var isGettingReward = false


    init {
        mRewardedVideoAd.rewardedVideoAdListener = this
    }

    fun loadAd() {
        mRewardedVideoAd.loadAd(
            "ca-app-pub-1818679104699845/8964537567",
            AdRequest.Builder().build()
        )
    }

    override fun onRewardedVideoAdClosed() {
        if (isGettingReward) isSucces(true, mContext.getString(R.string.odul_alindi), true)
        else isSucces(false, mContext.getString(R.string.reklam_kapatildi), false)
    }

    override fun onRewardedVideoAdLeftApplication() {
        isSucces(false, mContext.getString(R.string.uygulamadan_cikildi), false)
    }

    override fun onRewardedVideoAdLoaded() {
        if (isClickShowAd) mRewardedVideoAd.show()
    }

    override fun onRewardedVideoAdOpened() {
    }

    override fun onRewardedVideoCompleted() {
    }

    override fun onRewarded(p0: RewardItem?) {
        isSucces(true, mContext.getString(R.string.odul_alindi), false)
        isGettingReward = true
    }

    override fun onRewardedVideoStarted() {
    }

    override fun onRewardedVideoAdFailedToLoad(p0: Int) {
        isSucces(false, mContext.getString(R.string.reklam_yuklenemedi), false)
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