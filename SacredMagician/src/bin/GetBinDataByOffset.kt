package bin

import ApplicationLogger
import ApplicationSummary
import java.io.FileInputStream

class GetBinDataByOffset {
    companion object {
        fun get(offset: Long, isFloat: Boolean): Number {
            return try {
                val result = ConvertBytesToInt.convert(FileInputStream(ApplicationSummary.binPath), offset, isFloat)
                ApplicationLogger.logger.info("Loaded data by bytes: $result, offset: $offset")
                result
            } catch (ex: Exception) {
                ApplicationLogger.logger.error("An error occurred while loading data bytes on $offset")
                AppPrintStackTrace.print(ex)
                0
            }
        }
    }
}