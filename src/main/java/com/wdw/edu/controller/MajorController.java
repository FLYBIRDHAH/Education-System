package com.wdw.edu.controller;


import com.wdw.edu.common.R;
import com.wdw.edu.model.domain.Major;
import com.wdw.edu.model.transfer.MajorSaveRequest;
import com.wdw.edu.model.transfer.MajorUpdateNameRequest;
import com.wdw.edu.model.transfer.MajorUpdateNoRequest;
import com.wdw.edu.service.MajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangdaiwu
 * @since 2022-05-14
 */
@RestController
@RequestMapping("/major")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MajorController {

    private final MajorService majorService;

    @GetMapping("/list/{current}/{size}")
    public R list(@PathVariable Long current,
                  @PathVariable Long size) {
        return R.ok().data("page", majorService.listMajorResponse(current, size));
    }

    @GetMapping("/info/{id}")
    public R info(@PathVariable Integer id) {
        Major major = majorService.getById(id);
        return R.ok().data("major", major);
    }

    @GetMapping("/no-is-existed/{no}/{collegeId}")
    public R noIsExisted(@PathVariable Integer no,
                         @PathVariable Integer collegeId) {
        boolean noIsExisted = majorService.noIsExisted(no, collegeId);
        return R.ok().data("noIsExisted", noIsExisted);
    }

    @GetMapping("/name-is-existed/{name}")
    public R nameIsExisted(@PathVariable String name) {
        boolean nameIsExisted = majorService.nameIsExisted(name);
        return R.ok().data("nameIsExisted", nameIsExisted);
    }

    @PostMapping("/update")
    public R update(@RequestBody Major major) {
        majorService.updateById(major);
        return R.ok();
    }

    @PostMapping("/update/no")
    public R update(@RequestBody @Valid MajorUpdateNoRequest majorUpdateNoRequest) {
        Major major = new Major();
        BeanUtils.copyProperties(majorUpdateNoRequest, major);
        majorService.updateMajorNoById(major);
        return R.ok();
    }

    @PostMapping("/update/name")
    public R update(@RequestBody @Valid MajorUpdateNameRequest majorUpdateRequest) {
        Major major = new Major();
        BeanUtils.copyProperties(majorUpdateRequest, major);
        majorService.updateMajorNameById(major);
        return R.ok();
    }

    @PostMapping("/save")
    public R save(@RequestBody MajorSaveRequest majorSaveRequest) {
        Major major = new Major();
        BeanUtils.copyProperties(majorSaveRequest, major);
        majorService.saveMajor(major);
        return R.ok();
    }

    @PostMapping("/delete")
    public R delete(@RequestBody List<Integer> ids) {
        majorService.removeBatchByIds(ids);
        return R.ok();
    }
}

