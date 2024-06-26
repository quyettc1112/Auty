package com.Auty.Auty.AppConfig.BaseConfig

import android.app.ProgressDialog
import android.content.DialogInterface
import android.view.Gravity
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.Auty.Auty.AppConfig.DialogCustom.ConfirmDialog
import com.Auty.Auty.AppConfig.DialogCustom.ErrorDialog
import com.Auty.Auty.AppConfig.DialogCustom.NotifyDialog


open class BaseActivity : AppCompatActivity() {

    var progressDialog: ProgressDialog? = null

    open fun showLoading(
        isShow: Boolean
    ) {

    }

    open fun showLoading(
        title: String,
        message: String,
        cancelable: Boolean = true,
        cancelListener: ((DialogInterface) -> Unit) = {}
    ) {
        progressDialog = ProgressDialog(this)
        progressDialog?.setTitle(title)
        progressDialog?.setMessage(message)
        progressDialog?.setCancelable(cancelable)

        if (cancelable) {
            progressDialog?.setOnCancelListener(cancelListener)
        }

        progressDialog?.show()

    }

    open fun hideLoading() {
        progressDialog?.let {
            if (it.isShowing) {
                it.dismiss()
            }
        }
    }

    open fun showErrorDialog(message: String) {
        val errorDialog = ErrorDialog(this, message)
        errorDialog.show()
        errorDialog.window?.setGravity(Gravity.CENTER)
        errorDialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    open fun showNotifyDialog(
        titleResourceId: Int,
        messageResourceId: Int,
        textButtonResourceId: Int = -1
    ) {
        val title = getString(titleResourceId)
        val message = getString(messageResourceId)
        val textButton = if (textButtonResourceId == -1) null else getString(textButtonResourceId)
        showNotifyDialog(message, title, textButton)
    }

    open fun showNotifyDialog(message: String, title: String, textButton: String? = null) {
        val notifyDialog = NotifyDialog(this, title, message, textButton)
        notifyDialog.show()
        notifyDialog.window?.setGravity(Gravity.CENTER)
        notifyDialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    open fun showConfirmDialog(
        titleResourceId: Int,
        messageResourceId: Int = -1,
        positiveTitleResourceId: Int,
        negativeTitleResourceId: Int,
        textButtonResourceId: Int = -1,
        callback: ConfirmDialog.ConfirmCallback
    ) {

        val title = getString(titleResourceId)
        val message = if (messageResourceId != -1) getString(messageResourceId) else null
        val negativeButtonTitle = getString(negativeTitleResourceId)
        val positiveButtonTitle = getString(positiveTitleResourceId)
        val textButton = if (textButtonResourceId == -1) null else getString(textButtonResourceId)
        showConfirmDialog(
            title,
            message,
            negativeButtonTitle,
            positiveButtonTitle,
            textButton,
            callback
        )
    }

    open fun showConfirmDialog(
        title: String,
        message: String?,
        positiveButtonTitle: String,
        negativeButtonTitle: String,
        textButton: String?,
        callback: ConfirmDialog.ConfirmCallback
    ) {
        val confirmDialog = ConfirmDialog(
            context = this,
            title = title,
            message = message,
            positiveButtonTitle = positiveButtonTitle,
            negativeButtonTitle = negativeButtonTitle,
            callback = callback
        )
        confirmDialog.show()
        confirmDialog.window?.setGravity(Gravity.CENTER)
        confirmDialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }




    /*open fun showLoginDialog(context: Context, activity: Activity, navId: Int) {
        val dialogBinding = layoutInflater.inflate(R.layout.dialog_login, null)
        val myDialog = Dialog(context)
        myDialog.setContentView(dialogBinding)
        myDialog.setCancelable(true)
        myDialog.window?.setLayout(Screen.width, Screen.height)
        myDialog.window?.setBackgroundDrawable(ColorDrawable(context.getColor(R.color.zxing_transparent)))
        myDialog.show()

        // trường hợp người dùng bấm back stack
        myDialog.setOnDismissListener {
            val activity = activity
            val navController = activity.findNavController(R.id.nav_host_fragment_activity_main)
            navController.navigate(Constant.getNavSeleted(navId))
            val bottomBar = activity.findViewById<NiceBottomBar>(R.id.bottomBar)
            bottomBar.setActiveItem(0)

        }

        // trường hợp họ bấm close
        myDialog.findViewById<ImageButton>(R.id.imv_close).let {
            it.setOnClickListener {
                val activity = activity
                val navController = activity.findNavController(R.id.nav_host_fragment_activity_main)
                navController.navigate(Constant.getNavSeleted(navId))
                val bottomBar = activity.findViewById<NiceBottomBar>(R.id.bottomBar)
                bottomBar.setActiveItem(0)
                myDialog.dismiss()
            }
        }

        // trường hợp bấm login
        myDialog.findViewById<Button>(R.id.btn_Login).let {
            it.setOnClickListener {
                val intent = Intent(context, LoginActivity::class.java)
                startActivity(intent)
                myDialog.dismiss()
                finish()

            }
        }




    }*/
}