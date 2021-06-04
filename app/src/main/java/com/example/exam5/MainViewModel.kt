package com.example.exam5
import android.app.Application
import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONException

class MainViewModel: ViewModel() {
    val mainLiveData = MutableLiveData<MutableList<MutableList<Field>>>().apply {
        mutableListOf<MutableList<Field>>()
    }

    private var Fields = mutableListOf<MutableList<Field>>()

    fun init(jsonStr:String){
        viewModelScope.launch {
            withContext(Dispatchers.Default){
                initLiveData(jsonStr)
            }

        }

    }

    private suspend fun initLiveData(jsonStr:String){
        parseJson(jsonStr)
        mainLiveData.postValue(Fields)
    }

    private suspend fun parseJson (jsonStr:String){
        try {
            var jsonArray = JSONArray(jsonStr)
            for (i in 0 until jsonArray.length()) {
                var arrJson = jsonArray.getJSONArray(i)
                for (j in 0 until arrJson.length()) {
                    val jsonObj = arrJson.getJSONObject(j)
                    Fields[i][j] = Field(
                        jsonObj.getInt("field_id"),
                        jsonObj.getString("hint"),
                        jsonObj.getString("field_type"),
                        jsonObj.getBoolean("required"),
                        jsonObj.getBoolean("is_active"),
                        jsonObj.getString("icon"),
                        jsonObj.getString("keyboard"),
                    )
                }
            }
        }catch(e:JSONException){
            d("errorMessage",e.message.toString())
        }
    }
}