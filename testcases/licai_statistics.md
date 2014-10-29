业绩统计
==========================
####### 业绩统计页面
'''
        SELECT va.va_transfer, 1 product_type, m.m_id, m.m_caifu_id, ROUND(SUM(vf.vf_amount),2) vf_amount,
				DATE_FORMAT(vf.vf_service_time, '%Y年%m月') AS service_month, COUNT(0) AS counts,
				MIN(vf.vf_service_time) min_service_time, MAX(vf.vf_service_time) max_service_time, vf.vf_service_time pay_time,
				am.am_id, am.ad_id, am.am_name caifu_name
				FROM vip_form vf
				LEFT JOIN finance_plan fp ON fp.fp_id = vf.fp_id
				LEFT JOIN members m ON vf.m_id = m.m_id
				LEFT JOIN admin am ON m.m_caifu_id = am.am_id
				LEFT JOIN vip_account va ON va.fp_id=vf.fp_id AND va.m_id=vf.m_id
				WHERE vf.vf_mode>=8 AND vf.vf_mode <= 12 AND vf.vf_contract_status=1 AND m.m_caifu_id=256
				AND (va.va_transfer = 1 OR va.va_transfer IS NULL)
				 GROUP BY  YEAR(vf.vf_service_time), MONTH(vf.vf_service_time);
'''