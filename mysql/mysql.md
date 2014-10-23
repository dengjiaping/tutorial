nonobank sql
======================
###### 名校贷阀值

		SELECT COUNT(0) FROM (SELECT COUNT(0) FROM borrows_prepare bp
					LEFT JOIN products p ON bp.p_id =p.p_id
					LEFT JOIN members_field_details mfd ON mfd.m_id = bp.m_id
					LEFT JOIN student_schoole ss ON ss.ss_name = mfd.institution
					WHERE p.p_id = 77 AND bp.bp_is_success IN(0,1)
					AND ss.ss_address = '上海市'
					AND bp.bp_publish_time >= DATE_FORMAT(NOW(),'%Y-%m-%d 12:00:00')
					AND bp.bp_publish_time < DATE_FORMAT(DATE_ADD(NOW(),INTERVAL 1 DAY),'%Y-%m-%d 12:00:00')
					GROUP BY bp.m_id)T ;

		  -- list_ps

		SELECT COUNT(0) FROM (SELECT COUNT(0) FROM borrows_prepare bp
				LEFT JOIN products p ON bp.p_id =p.p_id
				LEFT JOIN members_field_details mfd ON mfd.m_id = bp.m_id
				LEFT JOIN student_schoole ss ON ss.ss_name = mfd.institution
				WHERE p.p_id = 77 AND bp.bp_is_success IN(0,1)
				AND ss.ss_name = '复旦大学'
				AND bp.bp_publish_time >= DATE_FORMAT(NOW(),'%Y-%m-%d 12:00:00')
				AND bp.bp_publish_time < DATE_FORMAT(DATE_ADD(NOW(),INTERVAL 1 DAY),'%Y-%m-%d 12:00:00')
				GROUP BY bp.m_id)T ;

		-- applied money

		SELECT SUM(money) FROM (SELECT SUM(bp_price_audit) AS money FROM borrows_prepare bp
				LEFT JOIN products p ON bp.p_id =p.p_id
				LEFT JOIN members_field_details mfd ON mfd.m_id = bp.m_id
				LEFT JOIN student_schoole ss ON ss.ss_name = mfd.institution
				WHERE p.p_id = 77 AND bp.bp_is_success IN(0,1)
				AND ss.ss_address = '上海市'
				AND bp.bp_publish_time >= DATE_FORMAT(DATE_ADD(NOW(),INTERVAL 1 DAY),'%Y-%m-%d 12:00:00')
				AND bp.bp_publish_time < DATE_FORMAT(NOW(),'%Y-%m-%d 12:00:00')
				GROUP BY bp.m_id)T;

		SELECT SUM(money) FROM (SELECT SUM(bp_price_audit) AS money FROM borrows_prepare bp
				LEFT JOIN products p ON bp.p_id =p.p_id
				LEFT JOIN members_field_details mfd ON mfd.m_id = bp.m_id
				LEFT JOIN student_schoole ss ON ss.ss_name = mfd.institution
				WHERE p.p_id = 77 AND bp.bp_is_success IN(0,1)
				AND ss.ss_name = '复旦大学'
				AND bp.bp_publish_time >= DATE_FORMAT(NOW(),'%Y-%m-%d 12:00:00')
				AND bp.bp_publish_time < DATE_FORMAT(DATE_ADD(NOW(),INTERVAL 1 DAY),'%Y-%m-%d 12:00:00')
				GROUP BY bp.m_id)T
		-- applied money
		SELECT SUM(bp_price_audit) FROM borrows_prepare bp
				LEFT JOIN products p ON bp.p_id =p.p_id
				LEFT JOIN members_field_details mfd ON mfd.m_id = bp.m_id
				LEFT JOIN student_schoole ss ON ss.ss_name = mfd.institution
				WHERE p.p_id = 77 AND bp.bp_is_success IN(0,1)
				-- AND ss.ss_address = '上海市'
				AND ss.ss_address IN (SELECT pt_name FROM province_threshold WHERE pt_parent=11)
				AND bp.bp_publish_time >= DATE_FORMAT(NOW(),'%Y-%m-%d 12:00:00')
				AND bp.bp_publish_time < DATE_FORMAT(DATE_ADD(NOW(),INTERVAL 1 DAY),'%Y-%m-%d 12:00:00');

		SELECT * FROM borrows_prepare ORDER BY 1 DESC;
		SELECT * FROM province_threshold;
		 -- province
		SELECT SUM(bp.bp_price_audit),COUNT(*),mfd.institution  FROM borrows_prepare bp
				LEFT JOIN products p ON bp.p_id =p.p_id
				LEFT JOIN members_field_details mfd ON mfd.m_id = bp.m_id
				LEFT JOIN student_schoole ss ON ss.ss_name = mfd.institution
				WHERE p.p_id = 83 AND bp.bp_is_success IN(0,1)
				AND ss.ss_address = '上海市'
				AND bp.bp_publish_time >= DATE_FORMAT(NOW(),'%Y-%m-%d 12:00:00')
				AND bp.bp_publish_time < DATE_FORMAT(DATE_ADD(NOW(),INTERVAL 1 DAY),'%Y-%m-%d 12:00:00')
				SELECT * FROM student_schoole WHERE ss_name = '东华大学' FOR UPDATE ;




