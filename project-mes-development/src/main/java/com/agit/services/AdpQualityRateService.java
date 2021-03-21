package com.agit.services;

import com.agit.controller.sample.model.AdpDailyDefectQCAssemblyReportModel;
import com.agit.controller.sample.model.AdpDailyDefectQCPreparationReportModel;
import com.agit.controller.sample.model.AdpDailyDefectQCSewingReportModel;
import com.agit.controller.sample.model.AdpQualityRateModel;
import com.agit.entity.JdcAdpTxnqcctrl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author TriAA
 */
public interface AdpQualityRateService {

    /**
     *
     * @param searchMap
     * @return
     */
    public List<AdpQualityRateModel> getreportQualityRate(Map<String, Object> searchMap);

    /**
     *
     * @return
     */
    public List<JdcAdpTxnqcctrl> getListProductCode();

    /**
     *
     * @param searchMap
     * @return
     */
    public List<AdpDailyDefectQCAssemblyReportModel> getDataReportAssembly(HashMap<String, Object> searchMap);

    /**
     *
     * @param searchMap
     * @return
     */
    public List<AdpDailyDefectQCSewingReportModel> getDataReportSewing(HashMap<String, Object> searchMap);

    /**
     *
     * @param searchMap
     * @return
     */
    public List<AdpDailyDefectQCPreparationReportModel> getDataReportPreparation(HashMap<String, Object> searchMap);
}
