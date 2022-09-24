let pagingComponent = {
    props: {
        pager: Object,
        findFunction: Function
    },

    template: '' +
        '<ul className="pagination">' +
        '<li  className="page-item" v-if="pager.prev >=0">' +
        '<a className="page-link" href="javascript:;" :value="pager.prev" @click="findFunction(pager.prev)" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>' +
        '</li>' +
        '<template v-if="pager.series && pager.series.length > 0">' +
                '<li className="page-item" v-for="i in pager.series" :class="{\'click\': pager.page == i}">' +
                    '<a className="page-link" href="javascript:;" :value="i" @click="findFunction(i)"><span>{{i+1}}</span></a>' +
                '</li>' +
            '</template>' +
            '<li className="page-item" v-if="pager.next >= 0">' +
                '<a className="page-link" href="javascript:;" :value="pager.next" @click="findFunction(pager.next)" aria-label="Next"><span aria-hidden="true">&raquo;</span></button>' +
            '</li>' +
        '</ul>'
};
function setPager(page, total, size) {
    page = page==null? 0: page;
    let pageNumberDisplayCount = 10;
    let pageNumberCount = parseInt(total / size); // 페이지버튼 갯수

    let remainCount = total % size;
    if(remainCount > 0) pageNumberCount += 1;

    let pageNumberOffset = ((page + 1) - pageNumberDisplayCount); // 페이지 번호 버튼 시작 지점
    if(pageNumberOffset < 0) pageNumberOffset = 0;

    let pageNumberEnd = pageNumberDisplayCount < pageNumberCount ? pageNumberDisplayCount : pageNumberCount; // 페이지 번호 버튼 끝 지점
    pageNumberEnd += pageNumberOffset;

    let series = [];
    for (var i=pageNumberOffset; i<pageNumberEnd; i++) {
        series.push(i);
    }

    return {
        total : total,
        page  : page,
        prev  : page - 1,
        series: series,
        next  : pageNumberCount > page + 1 ? page + 1 : -1,
    };
}
