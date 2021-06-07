package com.resumeims.server.impl;

import cn.afterturn.easypoi.cache.manager.FileLoaderImpl;
import cn.afterturn.easypoi.cache.manager.POICacheManager;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.view.EasypoiTemplateExcelView;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.resumeims.server.EmergencyMaterialInputService;
import com.resumeims.server.dao.EmergencyMaterialInputMapper;
import com.resumeims.server.dto.EmergencyMaterialInputSaveDTO;
import com.resumeims.server.entity.EmergencyMaterialInput;
import com.resumeims.server.entity.EmergencyMaterialInputEntity;
import com.resumeims.server.utils.ExcelExportUtils;
import com.resumeims.server.utils.Query;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业务实现类
 * 应急物资入库
 * </p>
 *
 * @author tanbao
 * @date 2020-11-10
 */
@Slf4j
@Service
public class EmergencyMaterialInputServiceImpl extends SuperServiceImpl<EmergencyMaterialInputMapper, EmergencyMaterialInput> implements EmergencyMaterialInputService {
    @Override
    public List<Map<String, Object>> populationIndexInfo() {
        return this.baseMapper.populationIndexInfo();
    }

    @Override
    public List<Map<String, Object>> rescueIndexInfo() {
        return this.baseMapper.rescueIndexInfo();
    }

    @Override
    public List<Map<String, Object>> rescueTotalInfo() {
        return this.baseMapper.rescueTotalInfo();
    }

    @Override
    public List<Map<String, Object>> rescueLevelTypeInfo() {
        Map<String, Object> mapType = new HashMap<>();
        Map<String, Object> mapLevel = new HashMap<>();
        List<String> typeList = new ArrayList<>();
        List<String> levelList = new ArrayList<>();
        //从字典查询类型
        String type = "ASSISTANCE_TYPE";
        List<Map<String, String>> resultType = this.baseMapper.rescueValue(type);
        for (Map map : resultType) {
            typeList.add(map.get("code").toString());
        }


        //从字典查询标准
        type = "EMERGENCY_CAPABILITY";
        List<Map<String, String>> resultLevel = this.baseMapper.rescueValue(type);
        for (Map map : resultLevel) {
            levelList.add(map.get("code").toString());
        }


        List<Map<String, Object>> result = this.baseMapper.rescueLevelTypeInfo(typeList, levelList);
        for (Map map : result) {
            map.put("typeList", typeList);
            map.put("levelList", levelList);
        }
/*
        result.add(mapType);
        result.add(mapLevel);*/
        return result;
    }

    @Override
    public List<Map<String, Object>> materialQuantityInfo() {
        return this.baseMapper.materialQuantityInfo();
    }

    @Override
    public Map<String, Object> materialTypeInfo() {
        Map<String, Object> materialCount = new HashMap<>();
        Map<String, Object> mapList = new HashMap<>();
        List<Map<String, Object>> typeList = new ArrayList<>();
        List<Map<String, Object>> result = this.baseMapper.materialTypeInfo();
        int materialTotal = 0;
        for (Map map : result) {
            materialTotal += Integer.parseInt(map.get("materialCount") != null ? map.get("materialCount").toString() : "0");
        }
        materialCount.put("materialTotal", materialTotal);
        typeList.add(materialCount);
        mapList.put("dataList", result);
        mapList.put("topList", typeList);
        return mapList;
    }

    @Override
    public List<Map<String, Object>> materialTypePositionInfo() {
        return this.baseMapper.materialTypePositionInfo();
    }

    @Override
    public Map<String, Object> shelterTypeInfo() {
        Map<String, Object> mapList = new HashMap<>();
        List<Map<String, Object>> typeList = new ArrayList<>();
        List<Map<String, Object>> list = this.baseMapper.shelterTypeInfo();
        Map<String, Object> listTop = this.baseMapper.shelterTypeInfoTop();
        typeList.add(listTop);
        mapList.put("dataList", list);
        mapList.put("topList", typeList);
        return mapList;
    }

    @Override
    public List<Map<String, Object>> teamQuantityInfo() {
        return this.baseMapper.teamQuantityInfo();
    }

    @Override
    public Map<String, Object> teamIndustryInfo() {
        Map<String, Object> mapList = new HashMap<>();
        List<Map<String, Object>> typeList = new ArrayList<>();
        List<Map<String, Object>> list = this.baseMapper.teamIndustryInfo();
        Map<String, Object> map = this.baseMapper.teamIndustryInfoTop();
        String map1 = this.baseMapper.teamScaleInfoTop();
        map.put("teamScale", map1);
        typeList.add(map);
        mapList.put("dataList", list);
        mapList.put("topList", typeList);
        return mapList;
    }

    @Override
    public List<Map<String, Object>> teamTypeInfo() {
        return this.baseMapper.teamTypeInfo();
    }

    @Override
    public List<Map<String, Object>> teamAgeInfo() {
        return this.baseMapper.teamAgeInfo();
    }

    @Override
    public List<Map<String, Object>> expertQuantityInfo() {
        return this.baseMapper.expertQuantityInfo();
    }

    @Override
    public Map<String, Object> expertEducationInfo() {
        Map<String, Object> mapList = new HashMap<>();
        List<Map<String, Object>> typeList = new ArrayList<>();
        List<Map<String, Object>> list = this.baseMapper.expertEducationInfo();
        Map<String, Object> map = this.baseMapper.expertEducationInfoTop();
        typeList.add(map);
        mapList.put("dataList", list);
        mapList.put("topList", typeList);

        return mapList;
    }

    @Override
    public List<Map<String, Object>> expertTypeLevelInfo() {
        return this.baseMapper.expertTypeLevelInfo();
    }

    @Override
    public Page materialInputPageInfo(Map<String, Object> params) {
        Page<EmergencyMaterialInputEntity> page = new Query<EmergencyMaterialInputEntity>(params).getPage();
        return page.setRecords(baseMapper.materialInputPageInfo(page, params));
    }

    @Override
    public List<EmergencyMaterialInputEntity> materialInputListInfo(Map<String, Object> params) {
        return baseMapper.materialInputListInfo(params);
    }

    @Override
    public void emergencyMaterialInputExcel(List<EmergencyMaterialInputEntity> populationIndexInfo, HttpServletRequest request, HttpServletResponse response) {

//      String type = (String)params.getMap().getOrDefault("type", ExcelType.XSSF.name());
        String sheetName = "应急物资";// (String)params.getMap().getOrDefault("sheetName", "SheetName");
        String fileName = "环保应急管理系统-应急物资";
        Map<String, Object> excelValue = new HashMap<String, Object>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        excelValue.put("title", "环保应急管理系统-应急物资");
        excelValue.put("siteName", "应急物资");
        excelValue.put("date", LocalDate.parse(dtf.format(LocalDate.now()), dtf));

        List<Map<String, Object>> valList = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> valListData = new ArrayList<>();
        Map<String, Object> mapv = new HashMap<>();
        EmergencyMaterialInputEntity mapvalue = new EmergencyMaterialInputEntity();
        int rowIndex = 5;
        for (int i = 0; i < populationIndexInfo.size(); i++) {
            mapvalue = populationIndexInfo.get(i);
            mapv = new HashMap<>();
            mapv.put("id", i + 1);
            mapv.put("materialname", mapvalue.getMaterialName() != null ? mapvalue.getMaterialName() : "");
            mapv.put("materialtype", mapvalue.getMaterialType() != null ? mapvalue.getMaterialType() : "");
            mapv.put("materialcount", mapvalue.getMaterialCount() != null ? mapvalue.getMaterialCount() : "");
            mapv.put("materialunit", mapvalue.getMaterialUnit() != null ? mapvalue.getMaterialUnit() : "");
            mapv.put("materialstandcount", mapvalue.getMaterialStandCount() != null ? mapvalue.getMaterialStandCount() : "");
            mapv.put("manager", mapvalue.getManager() != null ? mapvalue.getManager() : "");
            mapv.put("inputtime", dtf2.format(LocalDateTime.parse(mapvalue.getInputTime().toString())));
            mapv.put("storagetime", dtf.format(LocalDate.parse(mapvalue.getValidityDate().toString())));
            valListData.add(mapv);
            rowIndex++;
        }
        excelValue.put("valList", valListData);
        //excelValue.put("valList", valList);
        // 模板路径TemplateExportParams
        //String templateFile = EmergencyMaterialInputServiceImpl.class.getClassLoader().getResource("doc/hour001.xls").getPath();

        String templateFile = ExcelExportUtils.convertTemplatePath("doc/hour001.xls");

        //InputStream templateFile = EmergencyMaterialInputServiceImpl.class.getClassLoader().getResourceAsStream("doc/hour001.xls");


        TemplateExportParams exportTemplateParams = new TemplateExportParams(
                templateFile, sheetName);
        exportTemplateParams.setColForEach(true);

        POICacheManager.setFileLoader(new FileLoaderImpl());

       /* Map<String, Object> map = new HashMap<>(5);
        map.put("map", excelValue);
        map.put(NormalExcelConstants.PARAMS, exportTemplateParams);
        map.put(NormalExcelConstants.FILE_NAME, fileName);
        PoiBaseView.render(map, request, response, "easypoiTemplateExcelView");*/

        Workbook book = ExcelExportUtil.exportExcel(exportTemplateParams, excelValue);
        Sheet sheet = book.getSheetAt(0);
        Row head = sheet.getRow(1);
        Cell headOne = head.getCell(0);
        CellStyle cellStyle = headOne.getCellStyle();
        EasypoiTemplateExcelView easypoiTemplateExcelView = new EasypoiTemplateExcelView();
        try {
            easypoiTemplateExcelView.out(
                    book, fileName, request, response
            );
        } catch (Exception ex) {

        }
    }


   /* @Override
    public void emergencyMaterialInputExcel(List<EmergencyMaterialInputEntity> populationIndexInfo, HttpServletRequest request, HttpServletResponse response) {
        try {
            String sheetName = "应急物资";// (String)params.getMap().getOrDefault("sheetName", "SheetName");
            String fileName = "环保应急管理系统-应急物资";
            Map<String, Object> excelValue = new HashMap<String, Object>();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            excelValue.put("title", "环保应急管理系统-应急物资");
            excelValue.put("siteName", "应急物资");
            excelValue.put("date", LocalDate.parse(dtf.format(LocalDate.now()), dtf));
            List<Map<String, Object>> valList = new ArrayList<Map<String, Object>>();
            List<Map<String, Object>> valListData = new ArrayList<>();
            Map<String, Object> mapv = new HashMap<>();
            EmergencyMaterialInputEntity mapvalue = new EmergencyMaterialInputEntity();
            int rowIndex = 5;
            for (int i = 0; i < populationIndexInfo.size(); i++) {
                mapvalue = populationIndexInfo.get(i);
                mapv = new HashMap<>();
                mapv.put("id", i + 1);
                mapv.put("materialname", mapvalue.getMaterialName() != null ? mapvalue.getMaterialName() : "");
                mapv.put("materialtype", mapvalue.getMaterialType() != null ? mapvalue.getMaterialType() : "");
                mapv.put("materialcount", mapvalue.getMaterialCount() != null ? mapvalue.getMaterialCount() : "");
                mapv.put("materialunit", mapvalue.getMaterialUnit() != null ? mapvalue.getMaterialUnit() : "");
                mapv.put("manager", mapvalue.getManager() != null ? mapvalue.getManager() : "");
                mapv.put("inputtime", dtf2.format(LocalDateTime.parse(mapvalue.getInputTime().toString())));
                mapv.put("storagetime", dtf.format(LocalDate.parse(mapvalue.getValidityDate().toString())));
                valListData.add(mapv);
                rowIndex++;
            }

            excelValue.put("valList", valListData);
            // 模板路径
            String templateFile = EmergencyMaterialInputServiceImpl.class.getClassLoader().getResource("hour001.xls").getPath();
            TemplateExportParams exportTemplateParams = new TemplateExportParams(
                    templateFile, sheetName);
            exportTemplateParams.setColForEach(true);
            //
            POICacheManager.setFileLoader(new FileLoaderImpl());

            Map<String, Object> map = new HashMap<>(5);
            map.put("map", excelValue);
            map.put(NormalExcelConstants.PARAMS, exportTemplateParams);
//            String fileName = params.get("fileName").toString();
            map.put(NormalExcelConstants.FILE_NAME, fileName);
            PoiBaseView.render(map, request, response, "easypoiTemplateExcelView");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/

    public void downloadModel(Map params, HttpServletRequest request, HttpServletResponse response) {
        String model = params.get("model").toString();
//        String templateFile = EnvironmentJsonServiceImpl.class.getClassLoader().getResource("doc/"+model+".xlsx")
//                .getPath();
        try {
            Resource resource = new ClassPathResource("doc/" + model + ".xls");
//            File file = resource.getFile();
            String filename = resource.getFilename();
            InputStream inputStream = resource.getInputStream();
            response.setHeader("content-type", "application/octet-stream;charset=UTF-8");
            response.setContentType("application/octet-stream;charset=UTF-8");
//            response.addHeader("Content-Length", String.valueOf(file.length()));
            OutputStream out = response.getOutputStream();
            //使用URLEncoder来防止文件名乱码或者读取错误
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
            int b = 0;
            byte[] buffer = new byte[1000000];
            while (b != -1) {
                b = inputStream.read(buffer);
                if (b != -1) {
                    out.write(buffer, 0, b);
                }
            }
            inputStream.close();
            out.close();
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void upload(List<EmergencyMaterialInputEntity> factors, EmergencyMaterialInputSaveDTO dto) {
        List<EmergencyMaterialInput> emergencyMaterialInputs = new ArrayList<>();
        List<Map<String, Object>> stringList = baseMapper.selectManagerCode();
        for (EmergencyMaterialInputEntity factor : factors) {
            if (factor.getMaterialName() != null && !"".equals(factor.getMaterialName()) && factor.getMaterialType() != null && !"".equals(factor.getMaterialType())) {
                dto.setMaterialName(factor.getMaterialName() != null ? factor.getMaterialName() : "");
                dto.setMaterialType(factor.getMaterialType() != null ? factor.getMaterialType() : "");
                dto.setMaterialCount(factor.getMaterialCount() != null ? factor.getMaterialCount() : 0);
                dto.setMaterialStandCount(factor.getMaterialStandCount() != null ? factor.getMaterialStandCount() : 0);
                dto.setMaterialUnit(factor.getMaterialUnit() != null ? factor.getMaterialUnit() : "");
                //根据用户名查询对应负责人编号
                for (Map<String, Object> map : stringList) {
                    if (factor.getManager() != null) {
                        if (factor.getManager().equals(map.get("manager"))) {
                            dto.setManagerCode(map.get("manager_code").toString());
                        }
                    }
                }
                dto.setInputTime(LocalDateTime.now());
                dto.setValidityDate(factor.getValidityDate() != null ? factor.getValidityDate() : LocalDate.now());
                EmergencyMaterialInput model = BeanUtil.toBean(dto, getEntityClass());
                emergencyMaterialInputs.add(model);
            }
        }
        this.saveBatch(emergencyMaterialInputs);
    }
}
