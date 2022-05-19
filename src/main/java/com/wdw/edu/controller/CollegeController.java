package com.wdw.edu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wdw.edu.model.domain.College;
import com.wdw.edu.model.transfer.CollegeSaveRequest;
import com.wdw.edu.model.transfer.CollegeUpdateNameRequest;
import com.wdw.edu.model.transfer.CollegeUpdateNoRequest;
import com.wdw.edu.service.CollegeService;
import com.wdw.edu.common.R;
import com.wdw.edu.common.RPage;
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
@RequestMapping("/college")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CollegeController {

    private final CollegeService collegeService;

    @GetMapping("/list/{current}/{size}")
    public R list(@PathVariable Long current,
                  @PathVariable Long size) {
        Page<College> page = new Page<>(current, size);
        return R.ok().data("page", new RPage<College>(collegeService.page(page)));
    }

    @GetMapping("/list-all")
    public R listAll() {
        return R.ok().data("list", collegeService.list());
    }

    @GetMapping("/info/{id}")
    public R info(@PathVariable Integer id) {
        College college = collegeService.getById(id);
        return R.ok().data("college", college);
    }

    @GetMapping("/no-is-existed/{no}")
    public R noIsExisted(@PathVariable Integer no) {
        boolean noIsExisted = collegeService.noIsExisted(no);
        return R.ok().data("noIsExisted", noIsExisted);
    }

    @GetMapping("/name-is-existed/{name}")
    public R nameIsExisted(@PathVariable String name) {
        boolean nameIsExisted = collegeService.nameIsExisted(name);
        return R.ok().data("nameIsExisted", nameIsExisted);
    }

    @PostMapping("/update")
    public R update(@RequestBody College college) {
        collegeService.updateById(college);
        return R.ok();
    }

    @PostMapping("/update/no")
    public R update(@RequestBody @Valid CollegeUpdateNoRequest collegeUpdateNoRequest) {
        College college = new College();
        BeanUtils.copyProperties(collegeUpdateNoRequest, college);
        collegeService.updateCollegeNoById(college);
        return R.ok();
    }

    @PostMapping("/update/name")
    public R update(@RequestBody @Valid CollegeUpdateNameRequest collegeUpdateRequest) {
        College college = new College();
        BeanUtils.copyProperties(collegeUpdateRequest, college);
        collegeService.updateCollegeNameById(college);
        return R.ok();
    }

    @PostMapping("/save")
    public R save(@RequestBody @Valid CollegeSaveRequest collegeSaveRequest) {
        College college = new College();
        BeanUtils.copyProperties(collegeSaveRequest, college);
        collegeService.saveCollege(college);
        return R.ok();
    }

    @PostMapping("/delete")
    public R delete(@RequestBody List<Integer> ids) {
        collegeService.removeBatchByIds(ids);
        return R.ok();
    }
}

