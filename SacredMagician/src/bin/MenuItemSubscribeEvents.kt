package bin

import tornadofx.*

class MenuItemSubscribeEvents {
    companion object {
        fun subscribe() {
            BaseViewInstance.baseViewInstance.newFileMenuItem.action {
                OverwriteBalanceDialog.show("newFile")
            }

            BaseViewInstance.baseViewInstance.openFileMenuItem.action {
                OverwriteBalanceDialog.show("openFile")
            }

            BaseViewInstance.baseViewInstance.saveFileMenu.action {
                SaveBalanceBinData.save()
                BaseViewInstance.baseViewInstance.balanceBinFileChanged = false
                ApplicationSendData.sendUseStat("save-file")
            }

            BaseViewInstance.baseViewInstance.saveFileMenu.disableProperty().bind(BaseViewInstance.baseViewInstance.treeView.disableProperty())
            BaseViewInstance.baseViewInstance.saveAsFileMenu.disableProperty().bind(BaseViewInstance.baseViewInstance.treeView.disableProperty())
            BaseViewInstance.baseViewInstance.reloadFileMenu.disableProperty().bind(BaseViewInstance.baseViewInstance.treeView.disableProperty())

            BaseViewInstance.baseViewInstance.saveAsFileMenu.action {
                SaveAsFileDialog.open()
            }

            BaseViewInstance.baseViewInstance.reloadFileMenu.action {
                LoadBalanceBinData.load()
                BaseViewInstance.baseViewInstance.balanceBinFileChanged = false
                ApplicationSendData.sendUseStat("reload-file")
            }

            BaseViewInstance.baseViewInstance.applicationExitMenuItem.action {
                OverwriteBalanceDialog.show("appExit")
            }

            BaseViewInstance.baseViewInstance.readLicenseMenuItem.action {
                OpenBrowserLink.open("https://github.com/MairwunNx/SacredMagician/blob/master/LICENSE")
                ApplicationSendData.sendUseStat("read-license")
            }

            BaseViewInstance.baseViewInstance.readChangeLogMenuItem.action {
                OpenBrowserLink.open("https://github.com/MairwunNx/SacredMagician/blob/master/CHANGELOG.md")
                ApplicationSendData.sendUseStat("change-log")
            }

            BaseViewInstance.baseViewInstance.supportMailMenuItem.action {
                OpenBrowserLink.open("mailto://MairwunNx@gmail.com")
                ApplicationSendData.sendUseStat("mail-to")
            }

            BaseViewInstance.baseViewInstance.donateMenuItem.action {
                OpenBrowserLink.open("https://money.yandex.ru/to/410015993365458")
                ApplicationSendData.sendUseStat("donate-to")
            }

            BaseViewInstance.baseViewInstance.applicationAboutMenuItem.action {
                BaseViewInstance.baseViewInstance.aboutPane.isVisible = true
                ApplicationSendData.sendUseStat("about")
            }
        }
    }
}