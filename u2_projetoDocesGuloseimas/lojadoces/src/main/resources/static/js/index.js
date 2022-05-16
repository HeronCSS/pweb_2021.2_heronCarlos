var btn = document.getElementsByClassName('nav-item');

        btn[1].addEventListener('mouseover', function () {
            btn[1].style.marginLeft = '10%'
            btn[1].style.marginRight = '5%'
            document.getElementsByClassName('active')[0].style.marginRight = '0%';
            document.getElementsByClassName('active')[0].style.marginLeft = '5%';
        });
        btn[1].addEventListener('mouseout', function () {
            btn[1].style.margin = '0%';
            document.getElementsByClassName('active')[0].style.marginRight = '5%';
            document.getElementsByClassName('active')[0].style.marginLeft = '5%';
        });

        btn[2].addEventListener('mouseover', function () {
            btn[2].style.marginLeft = '10%'
            btn[2].style.marginRight = '5%'
            document.getElementsByClassName('active')[0].style.marginRight = '0%';
            document.getElementsByClassName('active')[0].style.marginLeft = '5%';
        });
        btn[2].addEventListener('mouseout', function () {
            btn[2].style.margin = '0%';
            document.getElementsByClassName('active')[0].style.marginRight = '5%';
            document.getElementsByClassName('active')[0].style.marginLeft = '5%';
        });

        //
        btn[3].addEventListener('mouseover', function () {
            btn[3].style.marginLeft = '15%'
            btn[3].style.marginRight = '5%'
            document.getElementsByClassName('active')[0].style.marginRight = '0%';
            document.getElementsByClassName('active')[0].style.marginLeft = '0%';
        });
        btn[3].addEventListener('mouseout', function () {
            btn[3].style.margin = '0%';
            document.getElementsByClassName('active')[0].style.marginRight = '5%';
            document.getElementsByClassName('active')[0].style.marginLeft = '5%';
        });

        //
        btn[4].addEventListener('mouseover', function () {
            btn[4].style.marginLeft = '15%'
            btn[4].style.marginRight = '5%'
            document.getElementsByClassName('active')[0].style.marginRight = '0%';
            document.getElementsByClassName('active')[0].style.marginLeft = '0%';
        });
        btn[4].addEventListener('mouseout', function () {
            btn[4].style.margin = '0%';
            document.getElementsByClassName('active')[0].style.marginRight = '5%';
            document.getElementsByClassName('active')[0].style.marginLeft = '5%';
        });

        //
        btn[5].addEventListener('mouseover', function () {
            btn[5].style.marginLeft = '15%'
            btn[5].style.marginRight = '5%'
            document.getElementsByClassName('active')[0].style.marginRight = '0%';
            document.getElementsByClassName('active')[0].style.marginLeft = '0%';
        });
        btn[5].addEventListener('mouseout', function () {
            btn[5].style.margin = '0%';
            document.getElementsByClassName('active')[0].style.marginRight = '5%';
            document.getElementsByClassName('active')[0].style.marginLeft = '5%';
        });

        