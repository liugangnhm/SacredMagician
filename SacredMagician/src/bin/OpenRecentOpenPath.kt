package bin

class OpenRecentOpenPath {
    companion object {
        fun open(path: String) {
            ApplicationSummary.binPath = path
            BaseViewInstance.baseViewInstance.filePathTextField.text = ApplicationSummary.binPath
            BaseViewInstance.baseViewInstance.balanceBinFileOpened = true
            BaseViewInstance.baseViewInstance.balanceBinFileChanged = false
            LoadBalanceBinData.load()
        }
    }
}