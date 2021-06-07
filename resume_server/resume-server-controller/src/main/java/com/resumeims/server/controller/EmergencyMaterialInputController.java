package com.resumeims.server.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.resumeims.resume_config.annotation.LoginUser;
import com.resumeims.resume_config.basecontroller.SuperController;
import com.resumeims.resume_config.log.SysLog;
import com.resumeims.resume_config.model.SysUser;
import com.resumeims.resume_config.utils.R;
import com.resumeims.server.EmergencyMaterialInputService;
import com.resumeims.server.dto.EmergencyMaterialInputPageDTO;
import com.resumeims.server.dto.EmergencyMaterialInputSaveDTO;
import com.resumeims.server.dto.EmergencyMaterialInputUpdateDTO;
import com.resumeims.server.entity.EmergencyMaterialInput;
import com.resumeims.server.entity.EmergencyMaterialInputEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * <p>
 * 前端控制器
 * 应急物资入库
 * </p>
 *
 * @author tanbao
 * @date 2020-11-10
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/emergencyMaterialInput")
@Api(value = "EmergencyMaterialInput", tags = "应急物资入库及仪表盘")
//@PreAuth(replace = "emergencyMaterialInput:")
public class EmergencyMaterialInputController extends SuperController<EmergencyMaterialInputService, Long, EmergencyMaterialInput, EmergencyMaterialInputPageDTO, EmergencyMaterialInputSaveDTO, EmergencyMaterialInputUpdateDTO> {
    @Autowired
    private EmergencyMaterialInputService emergencyMaterialInputService;

    /**
     * Excel导入后的操作
     *
     * @param list
     */
    @Override
    public R<Boolean> handlerImport(List<Map<String, String>> list) {
        List<EmergencyMaterialInput> emergencyMaterialInputList = list.stream().map((map) -> {
            EmergencyMaterialInput emergencyMaterialInput = EmergencyMaterialInput.builder().build();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            emergencyMaterialInput.setFacilityCode(map.get("场所编码"));
            emergencyMaterialInput.setInputManager(map.get("入库人"));
            emergencyMaterialInput.setInputTime(LocalDateTime.parse(map.get("入库时间"), df));
            emergencyMaterialInput.setManagerCode(map.get("负责人编码"));
            emergencyMaterialInput.setManufacturer(map.get("出厂厂家"));
            emergencyMaterialInput.setMaterialCode(map.get("物资编码"));
            emergencyMaterialInput.setMaterialCount(Integer.parseInt(map.get("物资数量")));
            emergencyMaterialInput.setMaterialStandCount(Integer.parseInt(map.get("标准数量")));
            emergencyMaterialInput.setMaterialName(map.get("物资名称"));
            emergencyMaterialInput.setMaterialType(map.get("物资类型"));
            emergencyMaterialInput.setMaterialUnit(map.get("物资单位"));
            emergencyMaterialInput.setMaterialUsage(map.get("物资用途"));
            emergencyMaterialInput.setPhoneNumber(map.get("厂家电话"));
            emergencyMaterialInput.setStatus(map.get("是否启用"));
            emergencyMaterialInput.setStorageTime(LocalDateTime.parse(map.get("存放日期"), df));
            emergencyMaterialInput.setValidityDate(LocalDate.parse(map.get("存放有效期"), df));
            //TODO 请在这里完成转换
            return emergencyMaterialInput;
        }).collect(Collectors.toList());

        return R.success(baseService.saveBatch(emergencyMaterialInputList));
    }

    /**
     * 应急物资列表导出Excel
     *
     * @return RestResponse
     */
    @ApiOperation(value = "应急物资列表导出Excel", notes = "应急物资列表导出Excel")
    @SysLog(value = "应急物资列表导出Excel", request = false)
    @RequestMapping(value = "/listExport", method = RequestMethod.GET)
    public R listexport(@RequestParam Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
        List<EmergencyMaterialInputEntity> populationIndexInfo = baseService.materialInputListInfo(params);
        emergencyMaterialInputService.emergencyMaterialInputExcel(populationIndexInfo, request, response);
        return R.success();
    }

    @ApiOperation(value = "导出应急物资模板")
    @PostMapping("/downloadModel")
    public R downloadModel(@RequestBody Map params, HttpServletRequest request, HttpServletResponse response) {
        emergencyMaterialInputService.downloadModel(params, request, response);
        return R.success();
    }

    @ApiOperation(value = "批量导入应急物资数据")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    //    @PreAuth("hasPermit('{}view')")
    public R upload(@RequestParam("file") MultipartFile multipartFile,
                    @ApiIgnore @LoginUser SysUser user) throws Exception {
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        params.setTitleRows(2);
        List<EmergencyMaterialInputEntity> factors = ExcelImportUtil.importExcel(multipartFile.getInputStream(),
                EmergencyMaterialInputEntity.class, params);
        EmergencyMaterialInputSaveDTO dto = new EmergencyMaterialInputSaveDTO();
//        this.setDTO(dto, user);
        emergencyMaterialInputService.upload(factors, dto);
        return R.success();
    }


    /*
    参照数据补足管理空气水质等导入
    private void setDTO(EmergencyMaterialInputSaveDTO saveDTO, SysUser user) {
        saveDTO.setCheckCode(UuidTools.generateShortUuid());
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        saveDTO.setUpdateTime(LocalDateTime.parse(fmt.format(LocalDateTime.now()), fmt));
        saveDTO.setCreateTime(LocalDateTime.parse(fmt.format(LocalDateTime.now()), fmt));
        saveDTO.setCreateUser(user.getId());
        saveDTO.setUpdateUser(user.getId());
        saveDTO.setIsCheck("2");
        saveDTO.setPackageId(Long.parseLong(UuidTools.createOrderId()));
    }*/

    @ApiOperation(value = "应急物资列表", notes = "应急物资列表")
    @SysLog(value = "应急物资列表", request = false)
//    @PreAuth("hasPermit('{}update')")
    @RequestMapping(value = "/populationIndexInfo", method = RequestMethod.GET)
    public R populationIndexInfo() {
        List<Map<String, Object>> populationIndexInfo = emergencyMaterialInputService.populationIndexInfo();
        return R.success(populationIndexInfo);
    }


    @ApiOperation(value = "救助场所统计-救助场所指标统计", notes = "救助场所统计-救助场所指标统计")
    @SysLog(value = "救助场所统计-救助场所指标统计", request = false)
//    @PreAuth("hasPermit('{}update')")
    @RequestMapping(value = "/rescueIndexInfo", method = RequestMethod.GET)
    public R rescueIndexInfo() {
        List<Map<String, Object>> rescueIndexInfo = emergencyMaterialInputService.rescueIndexInfo();
        return R.success(rescueIndexInfo);
    }

    @ApiOperation(value = "救助场所统计-救助场所总体统计", notes = "救助场所统计-救助场所总体统计")
    @SysLog(value = "救助场所统计-救助场所总体统计", request = false)
//    @PreAuth("hasPermit('{}update')")
    @RequestMapping(value = "/rescueTotalInfo", method = RequestMethod.GET)
    public R rescueTotalInfo() {
        List<Map<String, Object>> rescueTotalInfo = emergencyMaterialInputService.rescueTotalInfo();
        return R.success(rescueTotalInfo);
    }


    @ApiOperation(value = "救助场所统计-应急能力与类型交叉统计", notes = "救助场所统计-应急能力与类型交叉统计")
    @SysLog(value = "救助场所统计-应急能力与类型交叉统计", request = false)
//    @PreAuth("hasPermit('{}update')")
    @RequestMapping(value = "/rescueLevelTypeInfo", method = RequestMethod.GET)
    public R rescueLevelTypeInfo() {
        List<Map<String, Object>> rescueLevelTypeInfo = emergencyMaterialInputService.rescueLevelTypeInfo();
        return R.success(rescueLevelTypeInfo);
    }

    @ApiOperation(value = "应急物资统计-物资数量统计", notes = "应急物资统计-物资数量统计")
    @SysLog(value = "应急物资统计-物资数量统计", request = false)
//    @PreAuth("hasPermit('{}update')")
    @RequestMapping(value = "/materialQuantityInfo", method = RequestMethod.GET)
    public R materialQuantityInfo() {
        List<Map<String, Object>> materialQuantityInfo = emergencyMaterialInputService.materialQuantityInfo();
        return R.success(materialQuantityInfo);
    }

    @ApiOperation(value = "应急物资统计-物资类型统计", notes = "应急物资统计-物资类型统计")
    @SysLog(value = "应急物资统计-物资类型统计", request = false)
//    @PreAuth("hasPermit('{}update')")
    @RequestMapping(value = "/materialTypeInfo", method = RequestMethod.GET)
    public R materialTypeInfo() {
        Map<String, Object> materialTypeInfo = emergencyMaterialInputService.materialTypeInfo();
        return R.success(materialTypeInfo);
    }

    @ApiOperation(value = "应急物资统计-物资位置分布", notes = "应急物资统计-物资位置分布")
    @SysLog(value = "应急物资统计-物资位置分布", request = false)
//    @PreAuth("hasPermit('{}update')")
    @RequestMapping(value = "/materialTypePositionInfo", method = RequestMethod.GET)
    public R materialTypePositionInfo() {
        List<Map<String, Object>> materialTypePositionInfo = emergencyMaterialInputService.materialTypePositionInfo();
        return R.success(materialTypePositionInfo);
    }

    @ApiOperation(value = "避难场所统计-all", notes = "避难场所统计-all")
    @SysLog(value = "避难场所统计-all", request = false)
//    @PreAuth("hasPermit('{}update')")
    @RequestMapping(value = "/shelterTypeInfo", method = RequestMethod.GET)
    public R shelterTypeInfo() {
        Map<String, Object> shelterTypeInfo = emergencyMaterialInputService.shelterTypeInfo();
        return R.success(shelterTypeInfo);
    }

    @ApiOperation(value = "应急队伍统计-队伍总体统计", notes = "应急队伍统计-队伍总体统计")
    @SysLog(value = "应急队伍统计-队伍总体统计", request = false)
//    @PreAuth("hasPermit('{}update')")
    @RequestMapping(value = "/teamQuantityInfo", method = RequestMethod.GET)
    public R teamQuantityInfo() {
        List<Map<String, Object>> teamQuantityInfo = emergencyMaterialInputService.teamQuantityInfo();
        return R.success(teamQuantityInfo);
    }

    @ApiOperation(value = "应急队伍统计-行业类型队伍数量统计", notes = "应急队伍统计-行业类型队伍数量统计")
    @SysLog(value = "应急队伍统计-行业类型队伍数量统计", request = false)
//    @PreAuth("hasPermit('{}update')")
    @RequestMapping(value = "/teamIndustryInfo", method = RequestMethod.GET)
    public R teamIndustryInfo() {
        Map<String, Object> teamIndustryInfo = emergencyMaterialInputService.teamIndustryInfo();
        return R.success(teamIndustryInfo);
    }

    @ApiOperation(value = "应急队伍统计-队伍类型统计", notes = "应急队伍统计-队伍类型统计")
    @SysLog(value = "应急队伍统计-队伍类型统计", request = false)
//    @PreAuth("hasPermit('{}update')")
    @RequestMapping(value = "/teamTypeInfo", method = RequestMethod.GET)
    public R teamTypeInfo() {
        List<Map<String, Object>> teamTypeInfo = emergencyMaterialInputService.teamTypeInfo();
        return R.success(teamTypeInfo);
    }


    @ApiOperation(value = "应急队伍统计-队伍年龄结构分布统计", notes = "应急队伍统计-队伍年龄结构分布统计")
    @SysLog(value = "应急队伍统计-队伍年龄结构分布统计", request = false)
//    @PreAuth("hasPermit('{}update')")
    @RequestMapping(value = "/teamAgeInfo", method = RequestMethod.GET)
    public R teamAgeInfo() {
        List<Map<String, Object>> teamAgeInfo = emergencyMaterialInputService.teamAgeInfo();
        return R.success(teamAgeInfo);
    }

    @ApiOperation(value = "应急专家统计-应急专家总体统计", notes = "应急专家统计-应急专家总体统计")
    @SysLog(value = "应急专家统计-应急专家总体统计", request = false)
//    @PreAuth("hasPermit('{}update')")
    @RequestMapping(value = "/expertQuantityInfo", method = RequestMethod.GET)
    public R expertQuantityInfo() {
        List<Map<String, Object>> expertQuantityInfo = emergencyMaterialInputService.expertQuantityInfo();
        return R.success(expertQuantityInfo);
    }

    @ApiOperation(value = "应急专家统计-应急专家学历分类统计", notes = "应急专家统计-应急专家学历分类统计")
    @SysLog(value = "应急专家统计-应急专家学历分类统计", request = false)
//    @PreAuth("hasPermit('{}update')")
    @RequestMapping(value = "/expertEducationInfo", method = RequestMethod.GET)
    public R expertEducationInfo() {
        Map<String, Object> expertEducationInfo = emergencyMaterialInputService.expertEducationInfo();
        return R.success(expertEducationInfo);
    }

    @ApiOperation(value = "应急专家统计-应急专家领域与级别交叉统计", notes = "应急专家统计-应急专家领域与级别交叉统计")
    @SysLog(value = "应急专家统计-应急专家领域与级别交叉统计", request = false)
//    @PreAuth("hasPermit('{}update')")
    @RequestMapping(value = "/expertTypeLevelInfo", method = RequestMethod.GET)
    public R expertTypeLevelInfo() {
        List<Map<String, Object>> expertTypeLevelInfo = emergencyMaterialInputService.expertTypeLevelInfo();
        return R.success(expertTypeLevelInfo);
    }


    @ApiOperation(value = "物资资源分页列表查询")
    @GetMapping("/MaterialInputPageInfo")
    public R MaterialInputPageInfo(@RequestParam Map<String, Object> params) {
        Page page = emergencyMaterialInputService.materialInputPageInfo(params);
        return R.success(page);
    }

    @ApiOperation(value = "物资资源列表打印excel")
    @GetMapping("/MaterialInputListInfo")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
        String sheetName = "SheetName";
        String type = ExcelType.XSSF.name();
        List<EmergencyMaterialInputEntity> obj = emergencyMaterialInputService.materialInputListInfo(params);

        Map<String, Object> map = new HashMap<>(5);
        String title = params.get("title").toString();
        type = params.get("type").toString();
        sheetName = params.get("sheetName").toString();

        ExcelType excelType = ExcelType.XSSF.name().equals(type) ? ExcelType.XSSF : ExcelType.HSSF;
        map.put(NormalExcelConstants.DATA_LIST, obj);
        map.put(NormalExcelConstants.CLASS, EmergencyMaterialInputEntity.class);
        map.put(NormalExcelConstants.PARAMS, new ExportParams(title, sheetName, excelType));
        String fileName = params.get("fileName").toString();
        map.put(NormalExcelConstants.FILE_NAME, fileName);
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
        return R.success(obj);
    }
}
