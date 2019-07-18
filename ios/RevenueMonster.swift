//
//  RevenueMonster.swift
//  RevenueMonster
//
//  Created by Jun Kai Gan on 18/07/2019.
//  Copyright © 2019 Facebook. All rights reserved.
//

import Foundation

@objc(RevenueMonster)
class RevenueMonster: NSObject {
    
    @objc
    func constantsToExport() -> [AnyHashable : Any]! {
        return ["initialCount": 0]
    }
    
}
